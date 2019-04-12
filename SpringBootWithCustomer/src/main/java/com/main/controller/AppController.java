package com.main.controller;


import java.util.Base64;
import java.util.List;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.main.model.Beneficiary;
import com.main.model.CustomerRegistration;
import com.main.model.FundTransfer;
import com.main.model.SavingAccount;
import com.main.repository.CustomerRepository;
import com.main.service.BeneficiaryService;
import com.main.service.CustomerService;
import com.main.service.SavingAccountService;

@RestController
public class AppController {
	
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	Beneficiary beneficiary;
	
	
	@Autowired
	CustomerService customerService;
	@Autowired
	SavingAccountService savingAccountService;
	@Autowired
	BeneficiaryService beneficiaryService;
	
	@RequestMapping("/")
	public ModelAndView signup(@ModelAttribute("customer") CustomerRegistration customer) {
		return new ModelAndView ("Login");
	}
	
	@RequestMapping("/loginurl")
	public ModelAndView loginurl(@ModelAttribute("customer") CustomerRegistration customer) {
		return new ModelAndView ("redirect:/");
	}
	
	@RequestMapping("/login")
	public ModelAndView success(@ModelAttribute("customer")CustomerRegistration customer,HttpServletRequest req) {
		
		
        String name = "";
        String error = "Entered user or password are incorrect !";
        customer.setPassword(Base64.getEncoder().encodeToString(customer.getPassword().getBytes()));
       CustomerRegistration customer1 = customerService.findByUserNameAndPassword(customer.getUserName(), customer.getPassword());
        if (customer1 != null) {
              HttpSession session = req.getSession();
              session.setAttribute("customer", customer1);
              return new ModelAndView("redirect:/accsummary");
        } else {
              return new ModelAndView("Login", "error1", error);
        }

		
		
		
	            /*int i=0,j=0;
	            String name ="";
	            String error ="Username or Password is Incorrect";          
	            customer.setPassword(Base64.getEncoder().encodeToString(customer.getPassword().getBytes()));
	            
	           // CustomerRegistration cutomerReg = customerService.findByUserNameAndPassword(customer.getUserName(),customer.getPassword());
	            
	            List<CustomerRegistration> list=(List<CustomerRegistration>) customerService.findAll(customer);	         
	            	          
	            for (CustomerRegistration customer2 : list) {
	                  //System.out.println("Form Check 2"+customer2.getUserName());
	                  if((customer2.getUserName().equals(customer.getUserName())) &&(customer2.getPassword().equals(customer.getPassword())))
	                  {	                		                	  	              	  
		                	    i++;
		                	    System.out.println("Form Check 1 "+customer.getUserName());
		                        System.out.println("Checking Name "+customer2.getUserName());
		                        name=customer2.getFirstName()+" "+customer2.getLastName();
	                  }
	            }
	            if(i==1)
	            {
	            	  System.out.println("Success Name"+name);
	                 // return new ModelAndView("Success","name",name);
	            	
	            	HttpSession session = req.getSession();
		            session.setAttribute("customer",list);
		            return new ModelAndView("redirect:/accsummary");
	            	
	            }
	            else
	            {
	            	//System.out.println(error);
	                  return new ModelAndView("Login","error1",error);
	            }*/
	      }
	      
	@RequestMapping("/Registration")
	public ModelAndView registerCustomer(Model model,@ModelAttribute("customer") CustomerRegistration customer) {
		return new ModelAndView("Registration");
	}
	
	@RequestMapping("/CreateCustomer")
	public ModelAndView saveCustomer(Model model,@ModelAttribute("customer") CustomerRegistration customer) {
		
		customer.setPassword(Base64.getEncoder().encodeToString(customer.getPassword().getBytes()));
		customerService.saveCustomer(customer);
		
		return new ModelAndView ("Login");
	}
	
	@RequestMapping("/accsummary")
	public ModelAndView savingAccount(@ModelAttribute("customer") CustomerRegistration customer,HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		CustomerRegistration customer1 = (CustomerRegistration) session.getAttribute("customer");
		SavingAccount savingAccount1 = savingAccountService.findByCustomerIdAndAccType(customer1.getId(),"SAVING");
		 session.setAttribute("account", savingAccount1);
		ModelAndView mv = new ModelAndView("Success", "customer", customer1);
		if ( savingAccount1 == null) {
			System.out.println("useraccount does not created");
			mv.addObject( "useraccount", savingAccount1);
			// return new ModelAndView("Login");
		} else {
			System.err.println(savingAccount1);
			mv.addObject( "savingAccount1", savingAccount1);
		}
		String name = customer1.getFirstName()+" "+customer1.getLastName();
		mv.addObject("name",name);
		return mv;
		
	}
	
	
	@RequestMapping("/create")
	public ModelAndView createaccount(@ModelAttribute("customer") CustomerRegistration customer,HttpServletRequest request) {

		HttpSession session = request.getSession();
		CustomerRegistration customer1 = (CustomerRegistration) session.getAttribute("customer");
		System.out.println(customer1);
		SavingAccount account = new SavingAccount();
		account.setAccType("SAVING");
		account.setAccBalance(1000);
		account.setCustomer(customer1);
		 long millis=System.currentTimeMillis();    
		Date d=new Date(millis);
		account.setCreatedDate(d);
		System.out.println(LocalDateTime.now());
		account.setUpdatedDate(d);
		
		savingAccountService.save(account);
		
		return new ModelAndView("redirect:/accsummary");
	}
	
	
    @RequestMapping("/addBeneficiary")
    public ModelAndView addBeneficiary(@ModelAttribute("customer") CustomerRegistration customer,HttpServletRequest req){
                    
    	HttpSession session = req.getSession();
		CustomerRegistration customer1 = (CustomerRegistration) session.getAttribute("customer");
		String name = customer1.getFirstName()+" "+customer1.getLastName();
		ModelAndView mv = new ModelAndView("SelectBenefType");
                    return mv.addObject("name", name);
                    
    }
    @RequestMapping("/withinBank")
    public ModelAndView sameBankBeneficiary(@ModelAttribute("beneficiary") Beneficiary beneficiary){
                    
                    String str="IFSC No Needed";
                    
                    return new ModelAndView("AddBeneficiary","str",str);
                    
    }
    
    @RequestMapping("/sameBank")
    public ModelAndView sameBankBeneficierySave(HttpServletRequest req,@ModelAttribute("beneficiary") Beneficiary beneficiary){
                    HttpSession session=req.getSession();
                    CustomerRegistration customer = (CustomerRegistration) session.getAttribute("customer");
                    beneficiary.setCustomer(customer);
                    beneficiaryService.saveBeneficiery(beneficiary);
                    return new ModelAndView("redirect:/accsummary");
                    
    }
    
    @RequestMapping("/selectBank")
    public ModelAndView selectBank(@ModelAttribute("customer") CustomerRegistration customer,HttpServletRequest req){
                    
    	HttpSession session = req.getSession();
		CustomerRegistration customer1 = (CustomerRegistration) session.getAttribute("customer");
		String name = customer1.getFirstName()+" "+customer1.getLastName();
		ModelAndView mv = new ModelAndView("FundTransferType");
                    return mv.addObject("name", name);
                    
    }
    
    @RequestMapping("/WBank")
    public ModelAndView withBankTransfer(HttpServletRequest req,@ModelAttribute("beneficiary") Beneficiary beneficiary,
    		@ModelAttribute("savingAccount") SavingAccount savingAccount,
    		@ModelAttribute("customerRegistration") CustomerRegistration customerRegistration,
    		@ModelAttribute("fundTransfer") FundTransfer fundTransfer){
    	
    	String str="IFSC No Needed";
    	HttpSession session=req.getSession();
        CustomerRegistration customer = (CustomerRegistration) session.getAttribute("customer");
        beneficiary.setCustomer(customer);
    	 SavingAccount account = (SavingAccount) session.getAttribute("account");
         List<Beneficiary> beneficiaryList= beneficiaryService.findByCustomerId(customer.getId());
         for (Beneficiary beneficiary2 : beneficiaryList) {
				System.out.println("Name  "+beneficiary2.getName());
			}
         ModelAndView modelAndView = new ModelAndView("FundTransfer");
         modelAndView.addObject("customer",customer);
         modelAndView.addObject("list",beneficiaryList);
         String name = customer.getFirstName()+" "+customer.getLastName();
    	 modelAndView.addObject("str",str);

                    return  modelAndView;
                    
    }    
    
    @RequestMapping("/sameFundTransfer")
    public ModelAndView sameBankFundTransfer(HttpServletRequest req,
    		@ModelAttribute("beneficiary") Beneficiary beneficiary,
    		@ModelAttribute("savingAccount") SavingAccount savingAccount,
    		@ModelAttribute("customerRegistration") CustomerRegistration customerRegistration,
    		@ModelAttribute("fundTransfer") FundTransfer fundTransfer)
    {    	
    	HttpSession session=req.getSession();
    	CustomerRegistration customer = (CustomerRegistration) session.getAttribute("customer");
        SavingAccount account1 = (SavingAccount) session.getAttribute("account");
        long result = account1.getAccBalance()-fundTransfer.getAmount();
        
        beneficiaryService.saveFund(result,customer.getId());
        return new ModelAndView("redirect:/accsummary");
                    
    }
    
    
    @RequestMapping("/OtherBank")
    public ModelAndView otherBankBeneficiary(@ModelAttribute("beneficiary") Beneficiary beneficiary){
                    
                    String str="IFSC  Needed";
                    return new ModelAndView("AddBeneficiary","str",str);
                    
    }
    @RequestMapping("/otherBank")
    public ModelAndView otherBankBeneficierySave(HttpServletRequest req,@ModelAttribute("beneficiary") Beneficiary beneficiary){
                    HttpSession session=req.getSession();
                    CustomerRegistration customer = (CustomerRegistration) session.getAttribute("customer");
                    beneficiary.setCustomer(customer);
                    beneficiaryService.saveBeneficiery(beneficiary);
                    return new ModelAndView("redirect:/accsummary");
                    
    }
    
    @RequestMapping("/OBank")
    public ModelAndView otherBankTransfer(HttpServletRequest req,@ModelAttribute("beneficiary") Beneficiary beneficiary,
    		@ModelAttribute("savingAccount") SavingAccount savingAccount,
    		@ModelAttribute("customerRegistration") CustomerRegistration customerRegistration,
    		@ModelAttribute("fundTransfer") FundTransfer fundTransfer){
    	
    	String str="IFSC  Needed";
    	HttpSession session=req.getSession();
        CustomerRegistration customer = (CustomerRegistration) session.getAttribute("customer");
        beneficiary.setCustomer(customer);
    	 SavingAccount account = (SavingAccount) session.getAttribute("account");
         List<Beneficiary> beneficiaryList= beneficiaryService.findByCustomerId(customer.getId());
         for (Beneficiary beneficiary2 : beneficiaryList) {
				System.out.println("Name  "+beneficiary2.getName());
			}
         ModelAndView modelAndView = new ModelAndView("FundTransfer");
         modelAndView.addObject("customer",customer);
         modelAndView.addObject("list",beneficiaryList);
         String name = customer.getFirstName()+" "+customer.getLastName();
    	 modelAndView.addObject("str",str);

                    return  modelAndView;
                    
    }    
    
    
    
    
    
} 
    
    
    
    
    
    
    
   /* @RequestMapping("/add")
    public ModelAndView deleteCustomer(@ModelAttribute("customer")CustomerRegistration customer){
                    
    	            beneficiaryService.deleteCustomer(customer);
                    return new ModelAndView("redirect:/view");
                    
    }
*/
	
	
	
	/*@RequestMapping("/createsavingaccount")
	public ModelAndView savingAccount(@ModelAttribute("customer") SavingAccount savingAccount)
	{
		savingAccount.setId(1);
		savingAccount.setAccountType("Saving");
		savingAccount.setBalance(10000);
		
	    long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    System.out.println(date); 
	    
	    savingAccount.setDate(date);
	    
	    SavingAccount save = customerRepository.save(savingAccount);
	      
	    return new ModelAndView("Success","save",save);

	}*/
	

