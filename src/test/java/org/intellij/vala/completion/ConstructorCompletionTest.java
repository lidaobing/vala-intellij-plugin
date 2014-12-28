package org.intellij.vala.completion;

import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.testFramework.PlatformTestCase;
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;


public class ConstructorCompletionTest extends LightPlatformCodeInsightFixtureTestCase {

    public ConstructorCompletionTest() {
        PlatformTestCase.initPlatformPrefix("not_existing_class", "PlatformLangXml");
    }

    private static final int SINGLE_INVOCATION = 1;

    @Override
    protected String getTestDataPath() {
        return "src/test/resources/org/intellij/vala/completion/test";
    }

    protected boolean isWriteActionRequired() {
        return false;
    }

    public void testCompleteConstructorReferencingToClassInSameFile() {
        myFixture.configureByFiles("ConstructorCompletion.vala");

        myFixture.complete(CompletionType.BASIC, SINGLE_INVOCATION);

        myFixture.checkResultByFile("ConstructorCompletionAfter.vala");
    }

    public void testCompleteVariableTypeReferencingToClassInSameFile() {
        myFixture.configureByFiles("VariableTypeCompletionBefore.vala");

        myFixture.complete(CompletionType.BASIC, SINGLE_INVOCATION);

        myFixture.checkResultByFile("VariableTypeCompletionAfter.vala");
    }
}