import java.util.Scanner;

public class company_11 {
    public static void main(String[] args) {
        Scanner stew = new Scanner(System.in);

        System.out.println("RPG Load Providers");
        System.out.println("Loan Type\tInterest Rate");
        System.out.println("1. Home Loan\t4.2%");
        System.out.println("2. Car Loan\t3.9%");
        System.out.println("3. Gold Loan\t5.2%");
        System.out.println("4. Study Loan\t2.8%");
        System.out.println("5. Business Loan\t5.8%");
        System.out.println("6. Exit\n");

        System.out.print("ENTER YOUR FAMILY ANNUAL INCOME: ");
        double annualIncome = stew.nextDouble();
        
        if (annualIncome < 80000) {
            System.out.println("You are not eligible to get the loan from RPG Loan Providers,");
            return;
        
        }

        System.out.print("Enter the loan number you want to apply for (separated by commas): ");
        String[] LoanNumbers = stew.next().split(",");
        int SelectedLoanCount = LoanNumbers.length;
        
        
        if (SelectedLoanCount < 2) {
            System.out.println("You must select at least 2 loans.");
            return;

        }
        System.out.println("Enter the number of monthly installments (6 to 60 months): ");
        int tenure = stew.nextInt();

        if (tenure < 6 || tenure > 60) {
            System.out.println("Invalid number of minthly installments.");
            return;
        }

        double TotalLoanAMOUNT = 0;
        for (String LoanNumber : LoanNumbers ) {
            int LoanChoice = Integer.parseInt(LoanNumber.trim());
            double InterestRate = GetInterestRate(LoanChoice);
            if (TotalLoanAMOUNT > 500000) {
                InterestRate -= 0.10;
                
            }
            System.out.println("Enter the Loan Amount for loan type " + LoanChoice + ": $");
            double LoanAmount = stew.nextDouble();
            TotalLoanAMOUNT += LoanAmount * (1 + InterestRate / 100);

        }

        double InstallmentAmount = TotalLoanAMOUNT / tenure;

        System.out.println("\n Total Loan Amount to pay: $" + TotalLoanAMOUNT);
        System.out.println("Payment Installment Amount per month: $" + InstallmentAmount);
    }

    private static double GetInterestRate(int LoanChoice) {
        switch (LoanChoice) {
            case 1:
            return 4.2;
            case 2:
            return 3.9;
            case 3:
            return 5.2;
            case 4:
            return 2.8;
            case 5:
            return 5.8;
             default:
              throw new IllegalArgumentException("INVALID LOAN CHOICE.");

        }
    }
}


