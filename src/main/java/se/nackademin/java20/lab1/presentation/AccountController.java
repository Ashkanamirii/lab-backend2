package se.nackademin.java20.lab1.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.nackademin.java20.lab1.domain.CreditAccount;
import se.nackademin.java20.lab1.domain.DebitAccount;
import se.nackademin.java20.lab1.service.IAccountService;
import se.nackademin.java20.lab1.service.IClientService;

import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    IAccountService accountService;


   @PostMapping("/create")
   public ResponseEntity<Object> openAccount(@RequestBody CreateAccountDTO accountInfo) {

       if(accountInfo.getAccountType().equalsIgnoreCase("DEBIT")){
           DebitAccount account = new DebitAccount();
           account.setBalance(accountInfo.getBalance());
           return ResponseEntity.ok(accountService.createDebitAccount(account,accountInfo.getClientId()));
       }else if (accountInfo.getAccountType().equalsIgnoreCase("CREDIT")){
           CreditAccount account = new CreditAccount();
           account.setBalance(accountInfo.getBalance());
           return ResponseEntity.ok(accountService.createCreditAccount(account,accountInfo.getClientId()));
       }

       return ResponseEntity.badRequest().body( new Exception("Nothing failed to create account"));
   }









//    @GetMapping("/bank/{userId}/account")
//    public String openAccount(@PathVariable("userId") String userId) {
//        return "redirect:/bank/unknown/account/1";
//    }
//
//    @GetMapping("/bank/{userId}/account/{accountId}")
//    public String bankForm(@PathVariable("userId") String userId,
//                           @PathVariable("accountId") Long accountId, Model model) {
//        model.addAttribute("userId", userId);
//        model.addAttribute("accountId", accountId);
//        return "bank";
//    }

}
