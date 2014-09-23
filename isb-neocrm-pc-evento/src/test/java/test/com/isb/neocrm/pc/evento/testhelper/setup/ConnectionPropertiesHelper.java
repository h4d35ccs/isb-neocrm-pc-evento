package test.com.isb.neocrm.pc.evento.testhelper.setup;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConnectionPropertiesHelper {

    @Value("${db.server}")
    private String dbserver;
    @Value("${db.port}")
    private String port;
    @Value("${db.user}")
    private String username;
    @Value("${db.database}")
    private String databaseName;
    @Value("${db.vendor}")
    private String databaseVendor;
    
    public String getDbserver() {
        return dbserver;
    }
    public String getPort() {
        return port;
    }
    public String getUsername() {
        return username;
    }
    public String getDatabaseName() {
        return databaseName;
    }
    public String getDatabaseVendor() {
        return databaseVendor;
    }
}
