
package Person;

import Utils.Record.Record;
import java.util.List;

/**
 *
 * @author ashh412
 * 
 * Propósito: Guardar una referencia a las actuaciones de las personas
 * 
 */

public interface IPersonOperation {
    
    /**
     *
     * @return
     */
    public List<Record> getOperations();
    
    /**
     *
     * @param e
     */
    public void addOperation(Record e);
    
}