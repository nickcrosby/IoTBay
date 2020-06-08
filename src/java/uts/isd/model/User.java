
package uts.isd.model;

import uts.isd.model.dao.*;

import java.io.Serializable;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletRequest;

/**
 *
 * @author ncrosby17
 */
public class User implements Serializable {
    
    private int id;
    private int customerId;
    private String email;
    private String password;
    private Date dob;
    
    private Date createdDate;
    private int createdBy;
    private Date modifiedDate;
    private int modifiedBy;
    
    public User() { 
    
        this.createdDate = new Date();
        this.modifiedDate = new Date();
        this.createdBy = 0;
        this.modifiedBy = 0;   
    }
    
}
