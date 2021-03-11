package SystemExpert.system;

import SystemExpert.base.fact.IFact;
import SystemExpert.base.rule.Rule;
import java.util.List;

/**
 *
 * @author leogonz.gut
 */
public interface HumanInterface {

    int askIntValue(String paramString);

    boolean askBoolValue(String paramString);

    void printFacts(List<IFact> paramList);

    void printRules(List<Rule> paramList);

}
