package com.agencyglobalflights.salesagent.customermanage.infrastructure.in;

import java.io.Console;
import java.sql.SQLException;
import java.util.List;

import com.agencyglobalflights.admin.documentmanagement.application.ViewDocTypesUseCase;
import com.agencyglobalflights.admin.documentmanagement.domain.entity.DocumentType;
import com.agencyglobalflights.salesagent.customermanage.application.CreateCustomerUseCase;
import com.agencyglobalflights.salesagent.customermanage.application.UpdateCustomerUseCase;
import com.agencyglobalflights.salesagent.customermanage.application.ViewCustomerUseCase;
import com.agencyglobalflights.salesagent.customermanage.domain.entity.Customer;
import com.agencyglobalflights.utils.ConsoleUtils;

public class CustomerController {
    private CreateCustomerUseCase createCustUC;
    private UpdateCustomerUseCase updateCustUC;
    private ViewCustomerUseCase viewCustUC;
    private ViewDocTypesUseCase viewDocsUC;

    public CustomerController(CreateCustomerUseCase createCustUC, UpdateCustomerUseCase updateCustUC, ViewCustomerUseCase viewCustUC, ViewDocTypesUseCase viewDocsUC) {
        this.createCustUC = createCustUC;
        this.updateCustUC = updateCustUC;
        this.viewCustUC = viewCustUC;
        this.viewDocsUC = viewDocsUC;
    }

    public void createCustomer() throws SQLException {
        String REGEX_ONLY_DIGITS = "^\\d+$";
        ConsoleUtils.clear();
        
        System.out.println("Enter the Name: ");
        String name = ConsoleUtils.verifyEntryString();   

        System.out.println("Enter the Age ");
        int age = ConsoleUtils.verifyEntryInt(1, 100);
        
        viewallDocTypes();

        System.out.println("Please select the Type of Document: ");
        int doc_type = ConsoleUtils.verifyEntryInt(1, 3);

        System.out.println("Please select the ID Number: ");
        String idNumber = ConsoleUtils.verifyingStringFormat(REGEX_ONLY_DIGITS, "numbers only");

        Customer customer = new Customer(idNumber, name, age, doc_type);
        createCustUC.createCustomer(customer);
    }

    public void searchCustomer() throws SQLException {
        String REGEX_ONLY_DIGITS = "^\\d+$";
        ConsoleUtils.clear();
        System.out.println("Enter the Customer ID: ");
        String id = ConsoleUtils.verifyingStringFormat(REGEX_ONLY_DIGITS, "numbers only");
        viewCustomer(id);
        ConsoleUtils.waitWindow();
    }


    public Customer viewCustomer(String id) throws SQLException {
        
        Customer searchedCustomer = viewCustUC.viewCustomer(id);
        
        String border = "+------------+------+----------------------------+-----+";
        String header = "|     id     | Type |            Name            | Age |";
        ConsoleUtils.clear();
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        System.out.printf("| %-10s | %-4s | %-26s | %-3s |\n",
                    searchedCustomer.getId(), searchedCustomer.getDoc_type(), searchedCustomer.getName(), searchedCustomer.getAge());
        System.out.println(border);
    
        return searchedCustomer;
    }

    public void viewallDocTypes() throws SQLException {
        List<DocumentType> alltypes = viewDocsUC.viewAllTypes();
        String border = "+------+----------------------------------+";
        String header = "|  id  |               name               |";

        ConsoleUtils.clear();
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (DocumentType documentType : alltypes) {
            System.out.printf("| %-4d | %-32s |\n",
            documentType.getId(), documentType.getName());
        }
        System.out.println(border);
    }

    public void updateCustomer() throws SQLException {
        String REGEX_ONLY_DIGITS = "^\\d+$";

        System.out.println("\n" + "Please enter the ID of the Customer to edit:");
        String id = ConsoleUtils.verifyingStringFormat(REGEX_ONLY_DIGITS, "numbers only");
        ConsoleUtils.clear();

        viewCustomer(id);
        System.out.println("--------------------------------------\n" +
        "       Please select an option:       \n" +
        "--------------------------------------\n" +
        "\n" +
        "1. Update ID Number\n" +
        "2. Update Type of Document\n" +
        "3. Update Name\n" +
        "4. Update Age\n" +
        "5. Go back"
        );

        int op = ConsoleUtils.verifyEntryInt(1, 5);

        switch (op) {
            case 1:
                ConsoleUtils.clear();
                System.out.println("Enter the new ID Number: ");
                String newId = ConsoleUtils.verifyingStringFormat(REGEX_ONLY_DIGITS, "numbers only");
                updateCustUC.updateId(id, newId);
                break;
            case 2:
                ConsoleUtils.clear();
                viewallDocTypes();
                System.out.println("Select the new Document Type: ");
                int newDocType = ConsoleUtils.verifyEntryInt(1, 3);
                updateCustUC.updateDocType(id, newDocType);
                break;
            case 3:
                ConsoleUtils.clear();
                System.out.println("Enter the new Name: ");
                String newName = ConsoleUtils.verifyEntryString();
                updateCustUC.updateCustomerName(id, newName);
                break;
            case 4:
                ConsoleUtils.clear();
                System.out.println("Enter the new Age: ");
                int newAge = ConsoleUtils.verifyEntryInt(1, 100);
                updateCustUC.updateCustomerAge(id, newAge);
                break;
            case 5:
                return;
        
            default:
                break;
        }
    }

    

}
