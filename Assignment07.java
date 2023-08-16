import java.util.Scanner;

public class Assignment07{
    private static final Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String COLOR_GREEN_BOLD = "\033[33;1m";
        final String RESET = "\033[0m";

        final String DASHBOARD = "👷 Welcome to Smart Banking App";
        final String OPEN_ACCOUNT = "➕ Open New Account";
        final String DEPOSIT = "Deposit Money";
        final String WITHDRAW = "Withdraw Money";
        final String TRANSFER="Transfer Money";
        final String CHECK_BALANCE="Check Account Balance";
        final String DROP_ACCOUNT="Drop Existing Accont";
        
        
        final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
        final String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);
        
        // String[] names = new String[0];
        // double[] deposits=new double[0];

        String[][] details=new String[0][];
        
        String screen = DASHBOARD;
        int numberPart2=0;
        
mainLoop:
        do{
            final String APP_TITLE = String.format("%s%s%s",
            COLOR_BLUE_BOLD, screen, RESET);
            // System.out.println(CLEAR);
            System.out.println("\t" + APP_TITLE + "\n");

            switch(screen){
                case DASHBOARD:
                    System.out.println("\t[1]. Open New Account");
                    System.out.println("\t[2]. Deposit Money");
                    System.out.println("\t[3]. Withdraw Money");
                    System.out.println("\t[4]. Transfer Money");
                    System.out.println("\t[5]. Check Account Balance");
                    System.out.println("\t[6]. Drop Existing Accont");
                    System.out.println("\t[7]. Exit\n");
                    System.out.print("\tEnter an option to continue: ");
                    int option = scanner.nextInt();
                    scanner.nextLine();

                    switch(option){
                        case 1: screen=OPEN_ACCOUNT;break;
                        case 2: screen=DEPOSIT;break;
                        case 3: screen=WITHDRAW;break;
                        case 4: screen=TRANSFER;break;
                        case 5: screen=CHECK_BALANCE;break;
                        case 6: screen=DROP_ACCOUNT;break;
                        case 7: System.out.println(CLEAR); System.exit(0);
                        default: continue; 
                    }
                    break;
                case OPEN_ACCOUNT:
                    System.out.printf("\tID: SDB-%05d \n", (details.length + 1));


                    boolean valid;
                    String name;

                    do{
                        valid=true;
                        System.out.print("\tName:");
                        name=scanner.nextLine().strip();
                        if(name.isEmpty()){
                            System.out.printf(ERROR_MSG,"Name Can't be empty");
                            valid=false;
                            continue;
                        }
                        for (int i = 0; i < name.length(); i++) {
                            if (!(Character.isLetter(name.charAt(i)) || 
                                Character.isSpaceChar(name.charAt(i))) ) {
                                System.out.printf("\t%sInvalid Name%s\n", COLOR_RED_BOLD, RESET);
                                valid = false;
                                break;
                            }
                        }
                    }while(!valid);

                    

                    double deposit;
                    do{
                        valid=true;
                        System.out.print("\tInitial Deposit:");
                        deposit=scanner.nextDouble();
                        scanner.nextLine();
                        if(deposit<5000){
                            System.out.printf(ERROR_MSG,"Insuficient Amount Please Deposite more than Rs.5000.00");
                            valid=false;
                            continue;
                        }


                    }while(!valid);
                    
                    String[][] newDetails=new String[details.length+1][2];
                    for (int i = 0; i < details.length; i++) {
                        newDetails[i]=details[i];
                    }
                    newDetails[newDetails.length-1][0]=name;
                    newDetails[newDetails.length-1][1]=Double.toString(deposit);

                    details=newDetails;

                    System.out.println();
                    System.out.printf(SUCCESS_MSG,"\t" + name + " Your account created sucessfully.\n\tDo you want to create new Account (Y/n)? ");
                    if(scanner.nextLine().strip().toUpperCase().equals("Y"))continue;
                    screen=DASHBOARD;
                    break;
                    
                // case DEPOSIT:
                //     String accontNo;
                //     do{
                //         valid=true;
                //         if(details.length==0){
                //             System.out.printf(ERROR_MSG,"No Acconts created yet, Please create an Account");
                //             System.out.println("Do you want to create an account? (Y/n)");
                //             if(!scanner.nextLine().strip().toUpperCase().equals("Y")){
                //                 screen=DASHBOARD;
                //                 continue mainLoop;
                //             }
                //             screen=OPEN_ACCOUNT;
                //             continue mainLoop;
                //         }
                //         else{
                //             System.out.print("\tEnter Acount number to deposit money:");
                //             accontNo = scanner.nextLine().strip().toUpperCase();
                //         if(accontNo.isEmpty()){
                //             System.out.printf(ERROR_MSG,"Accont No. can't be empty");
                //             valid=false;
                //             }
                //         else if(!accontNo.startsWith("SDB-")||accontNo.length()<4){
                //             System.out.printf(ERROR_MSG,"Invalid Format");
                //             valid=false;
                //             }
                //         else{
                //             String numberPart = accontNo.substring(4);
                //             for (int i = 0; i < numberPart.length(); i++) {
                //                 if(!Character.isDigit(numberPart.charAt(i))){
                //                     System.out.printf(ERROR_MSG,"Invalid Format");
                //                     valid=false;
                //                     break;

                //                 }  
                //             }
                //             numberPart2 = Integer.parseInt(accontNo.substring(4));
                //             if(numberPart2!=names.length){
                //                 System.out.printf(ERROR_MSG,"Not Found Account No");
                //                 valid=false;
                //             }
                                
                //         }
                //         if(!valid){
                //             System.out.print("\n\tDo you want to try again? (Y/n)");
                //             if(!scanner.nextLine().strip().toUpperCase().equals("Y")){
                //                 screen=DASHBOARD;
                //                 continue mainLoop;
                //             }
                //         }
                //         }

                //     }while(!valid);
                //     System.out.printf("\tCurrent Balance:Rs.%s\n",deposits[numberPart2-1]);
                //     System.out.print("\tDeposit Amount:");
                //     deposit= scanner.nextDouble();
                //     scanner.nextLine();
                //     if(deposit<500){
                //         System.out.printf(ERROR_MSG,"Insuficient Amount\n");
                //         System.out.print("do you screenwant to redeposit? (Y/n)");
                //         if(scanner.nextLine().strip().toUpperCase().equals("Y")){
                //             screen=DEPOSIT;
                //             continue mainLoop;
                //         }

                //     }
                //     deposits[numberPart2-1]=deposit+deposits[numberPart2-1];
                //     System.out.printf("\tNew balance:Rs.%.2f",deposits[numberPart2-1]);
                //     System.out.print("Do you want to continue? (Y/n)");
                //     if(scanner.nextLine().strip().toUpperCase().equals("Y")){
                //         screen=DEPOSIT;
                //         continue mainLoop;
                //     }
                //     screen=DASHBOARD;
                //     break;
                // case WITHDRAW:
                //     do{
                //         valid=true;
                //         if(names.length==0){
                //             System.out.printf(ERROR_MSG,"No Acconts created yet, Please create an Account");
                //             System.out.println("Do you want to create an account? (Y/n)");
                //             if(!scanner.nextLine().strip().toUpperCase().equals("Y")){
                //                 screen=DASHBOARD;
                //                 continue mainLoop;
                //             }
                //             screen=OPEN_ACCOUNT;
                //             continue mainLoop;
                //         }
                //         else{
                //             System.out.print("\tEnter Acount number to Withraw money:");
                //             accontNo = scanner.nextLine().strip().toUpperCase();
                //         if(accontNo.isEmpty()){
                //             System.out.printf(ERROR_MSG,"Accont No. can't be empty");
                //             valid=false;
                //             }
                //         else if(!accontNo.startsWith("SDB-")||accontNo.length()<4){
                //             System.out.printf(ERROR_MSG,"Invalid Format");
                //             valid=false;
                //             }
                //         else{
                //             String numberPart = accontNo.substring(4);
                //             for (int i = 0; i < numberPart.length(); i++) {
                //                 if(!Character.isDigit(numberPart.charAt(i))){
                //                     System.out.printf(ERROR_MSG,"Invalid Format");
                //                     valid=false;
                //                     break;

                //                 }  
                //             }
                //             numberPart2 = Integer.parseInt(accontNo.substring(4));
                //             if(numberPart2!=names.length){
                //                 System.out.printf(ERROR_MSG,"Not Found Account No");
                //                 valid=false;
                //             }
                                
                //         }
                //         if(!valid){
                //             System.out.print("\n\tDo you want to try again? (Y/n)");
                //             if(!scanner.nextLine().strip().toUpperCase().equals("Y")){
                //                 screen=DASHBOARD;
                //                 continue mainLoop;
                //             }
                //         }
                //         }

                //     }while(!valid);
                //     System.out.printf("\tCurrent Balance:Rs.%s\n",deposits[numberPart2-1]);
                //     System.out.print("\tWithdraw Amount:");
                    
                //     deposit= scanner.nextDouble();
                //     scanner.nextLine();
                //     if(deposit<500){
                //         System.out.printf(ERROR_MSG,"Insuficient Amount\n");
                //         System.out.print("do you screenwant to redeposit? (Y/n)");
                //         if(scanner.nextLine().strip().toUpperCase().equals("Y")){
                //             screen=DEPOSIT;
                //             continue mainLoop;
                //         }

                //     }
                //     deposits[numberPart2-1]=deposit+deposits[numberPart2-1];
                //     System.out.printf("\tNew balance:Rs.%.2f",deposits[numberPart2-1]);
                //     System.out.print("Do you want to continue? (Y/n)");
                //     if(scanner.nextLine().strip().toUpperCase().equals("Y")){
                //         screen=DEPOSIT;
                //         continue mainLoop;
                //     }
                //     screen=DASHBOARD;
                //     break;
                    
                    

                case TRANSFER:
                case CHECK_BALANCE:
                case DROP_ACCOUNT:






            }

        }while(true);


    }
}