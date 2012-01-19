/*
* generated by Xtext
*/
parser grammar InternalSandboxParser;

options {
	tokenVocab=InternalSandboxLexer;
	superClass=AbstractInternalAntlrParser;
	
}

@header {
package org.osate.xtext.aadl2.sandbox.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.xtext.aadl2.sandbox.services.SandboxGrammarAccess;

}

@members {


	private SandboxGrammarAccess grammarAccess;
	 	
	public InternalSandboxParser(TokenStream input, SandboxGrammarAccess grammarAccess) {
		this(input);
		this.grammarAccess = grammarAccess;
		registerRules(grammarAccess.getGrammar());
	}
	
	@Override
	protected String getFirstRuleName() {
		return "Sandbox";	
	} 
	   	   	
	@Override
	protected SandboxGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}
}

@rulecatch { 
	catch (RecognitionException re) { 
	    recover(input,re); 
	    appendSkippedTokens();
	}
}




// Entry rule entryRuleSandbox
entryRuleSandbox returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getSandboxRule()); }
	 iv_ruleSandbox=ruleSandbox 
	 { $current=$iv_ruleSandbox.current; } 
	 EOF 
;

// Rule Sandbox
ruleSandbox returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	otherlv_0=KEYWORD_5
    {
    	newLeafNode(otherlv_0, grammarAccess.getSandboxAccess().getSandboxKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getSandboxAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSandboxRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getSandboxAccess().getSystemInstanceSystemConfigurationParserRuleCall_2_0()); 
	    }
		lv_systemInstance_2_0=ruleSystemConfiguration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSandboxRule());
	        }
       		add(
       			$current, 
       			"systemInstance",
        		lv_systemInstance_2_0, 
        		"SystemConfiguration");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleSystemConfiguration
entryRuleSystemConfiguration returns [EObject current=null]
	:
	{ newCompositeNode(grammarAccess.getSystemConfigurationRule()); }
	 iv_ruleSystemConfiguration=ruleSystemConfiguration 
	 { $current=$iv_ruleSystemConfiguration.current; } 
	 EOF 
;

// Rule SystemConfiguration
ruleSystemConfiguration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	otherlv_0=KEYWORD_4
    {
    	newLeafNode(otherlv_0, grammarAccess.getSystemConfigurationAccess().getSystemKeyword_0());
    }

	otherlv_1=KEYWORD_6
    {
    	newLeafNode(otherlv_1, grammarAccess.getSystemConfigurationAccess().getInstanceKeyword_1());
    }
(
(
		lv_name_2_0=RULE_ID
		{
			newLeafNode(lv_name_2_0, grammarAccess.getSystemConfigurationAccess().getNameIDTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemConfigurationRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"ID");
	    }

)
)
	otherlv_3=KEYWORD_3
    {
    	newLeafNode(otherlv_3, grammarAccess.getSystemConfigurationAccess().getFromKeyword_3());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSystemConfigurationRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSystemConfigurationAccess().getSystemImplementationSystemImplementationCrossReference_4_0()); 
	    }
		ruleQIREF		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleQIREF
entryRuleQIREF returns [String current=null] 
:
	{ newCompositeNode(grammarAccess.getQIREFRule()); } 
	 iv_ruleQIREF=ruleQIREF 
	 { $current=$iv_ruleQIREF.current.getText(); }  
	 EOF 
;

// Rule QIREF
ruleQIREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule();
    }:
((    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getQIREFAccess().getIDTerminalRuleCall_0_0()); 
    }

	kw=KEYWORD_2 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQIREFAccess().getColonColonKeyword_0_1()); 
    }
)*    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getQIREFAccess().getIDTerminalRuleCall_1()); 
    }

	kw=KEYWORD_1 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQIREFAccess().getFullStopKeyword_2()); 
    }
    this_ID_4=RULE_ID    {
		$current.merge(this_ID_4);
    }

    { 
    newLeafNode(this_ID_4, grammarAccess.getQIREFAccess().getIDTerminalRuleCall_3()); 
    }
)
    ;






