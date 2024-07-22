package com.agencyglobalflights.salesagent.customermanage;

import java.sql.SQLException;

import com.agencyglobalflights.admin.documentmanagement.application.ViewDocTypesUseCase;
import com.agencyglobalflights.admin.documentmanagement.domain.service.DocTypeService;
import com.agencyglobalflights.admin.documentmanagement.infrastructure.out.DocTypeRepository;
import com.agencyglobalflights.salesagent.bookingmanage.domain.service.FlightBookingService;
import com.agencyglobalflights.salesagent.bookingmanage.infrastructure.out.FlightBookingRepository;
import com.agencyglobalflights.salesagent.customermanage.application.CreateCustomerUseCase;
import com.agencyglobalflights.salesagent.customermanage.application.UpdateCustomerUseCase;
import com.agencyglobalflights.salesagent.customermanage.application.ViewCustomerUseCase;
import com.agencyglobalflights.salesagent.customermanage.domain.service.CustomerService;
import com.agencyglobalflights.salesagent.customermanage.infrastructure.in.CustomerController;
import com.agencyglobalflights.salesagent.customermanage.infrastructure.out.CustomerRepository;
import com.agencyglobalflights.utils.ConsoleUtils;

public class CustomerManageView {

    public void showmenu() throws SQLException {
        CustomerService cs = new CustomerRepository();
        DocTypeService ds = new DocTypeRepository();
        CreateCustomerUseCase ccuc = new CreateCustomerUseCase(cs);
        UpdateCustomerUseCase upcuc = new UpdateCustomerUseCase(cs);
        ViewCustomerUseCase vicuc = new ViewCustomerUseCase(cs);
        ViewDocTypesUseCase vduc = new ViewDocTypesUseCase(ds);

        CustomerController cc = new CustomerController(ccuc, upcuc, vicuc, vduc);
    

        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "         Customer Management:          \n" +
            "       Please select an option:        \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. View customer information\n" +
            "2. Update customer info\n" +
            "3. Create customer \n" +
            "4. Go back\n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 4);


            switch (op) {
                case 1:
                    cc.searchCustomer();
                    break;
                case 2:
                    cc.updateCustomer();
                    break;
                case 3:
                    cc.createCustomer();
                    break;
                case 4:

                    break;
                case 5:
                
                    break;
                default:
                    break;
            }

        } while (true);

    }
}
