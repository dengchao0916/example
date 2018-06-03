package com.dengchao.service;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.dengchao.entity.Account;

public class AccountService4 {
    /*
     * @Cacheable(value=”accountCache”)，这个注释的意思是，
     * 当调用这个方法的时候，会从一个名叫 accountCache 的缓存中查询，
     * 如果没有，则执行实际的方法（即查询数据库），并将执行的结果存入缓存中，
     * 否则返回缓存中的对象。这里的缓存中的 key 就是参数 userName，value 就是 Account 对象。
     * “accountCache”缓存是在 spring*.xml 中定义的名称。
     */
    
    @Cacheable(value="accountCache")// 使用了一个缓存名叫 accountCache 
    public Account getAccountByName(String userName) { 
      // 方法内部实现不考虑缓存逻辑，直接实现业务
      return getFromDB(userName); 
    } 
    
    // 更新accountCache缓存，确保方法被执行，同时方法的返回值也被记录到缓存中
    @CachePut(value="accountCache",key="#account.getName()")
    public Account updateAccount(Account account) { 
      return updateDB(account); 
    } 
    
    private Account updateDB(Account account) { 
      System.out.println("real updating db..."+account.getName()); 
      return account; 
    }
    
    private Account getFromDB(String acctName) { 
        System.out.println("real querying db..."+acctName); 
        return new Account(acctName); 
      } 
}
