package com.common.util;

import java.text.StringCharacterIterator;

import org.apache.commons.validator.EmailValidator;

import com.common.util.AccountUtil;

public class AccountUtil
{	
	private static final int PWD_MIN_LENGTH =  8;				
	private static final int PWD_MAX_LENGTH =  32;			
	private static final int USERNAME_MIN_LENGTH = 3;
	private static final int USERNAME_MAX_LENGTH = 32;
	
	
	
	public static boolean validateEmail(String val) 
	{
		EmailValidator validator = EmailValidator.getInstance();
		return validator.isValid(val);
	}

	public static boolean validateUsername(String val) {
		boolean isValid_flag =false;
		boolean userHasContent = ((val != null)
												&& (!val.equals(""))
												&& (val.length() >= USERNAME_MIN_LENGTH)
												&& (val.length() < USERNAME_MAX_LENGTH));
		
		if(!userHasContent) {
			isValid_flag=false; 
		} 
		else {
			StringCharacterIterator iterator = new StringCharacterIterator(val);
			char aChar = iterator.current();
			while( aChar != StringCharacterIterator.DONE ) {
				isValid_flag = ((aChar >= 'A' && aChar <= 'Z')
						|| (aChar >= 'a' && aChar <= 'z')
						|| Character.isDigit(aChar));
				
				if( !isValid_flag ) {		
					return isValid_flag;	
				}
				aChar = iterator.next();	
			}
		}
		return isValid_flag;
	}
	
	
	
	public static boolean validatePwd(String val) 
	{
		boolean isValid_flag = false;
		boolean passwordHasContent = ((val != null) 
															&& (!val.equals(""))
															&& (val.length() >= PWD_MIN_LENGTH)		
															&& (val.length() < PWD_MAX_LENGTH));	
		
		
		if( !passwordHasContent ) 	{		
			isValid_flag = false; 
		} 
		else {
			StringCharacterIterator iterator = new StringCharacterIterator( val );
			char aChar = iterator.current();			// Get the current character.
				
			while( aChar != StringCharacterIterator.DONE ) {
				isValid_flag = ((aChar >= 'A' && aChar <= 'Z')
						|| (aChar >= 'a' && aChar <= 'z')
						|| Character.isDigit(aChar));
				
				if( !isValid_flag ) {		
					return isValid_flag;	
				}
				aChar = iterator.next();		
			}
		}
		return isValid_flag;
	}

}
