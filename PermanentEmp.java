package Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/*=================================================================================*/

public class PermanentEmp extends Employee {

	int paid_leave, sick_leave, casual_leave;
	double basic,hra,pfa;
	
	PermanentEmp(int id,String Name,double sal)
	{
		paid_leave=5;
		sick_leave=2;
		casual_leave=1;
		empId=id;
		empName=Name;
		basic=sal;
		hra=basic/2;
		pfa=basic*0.12;
		
	}
/*============method will calculate remaining leaves ==========*/	
	void calculate_balance_leaves()
	{
		System.out.println("Paid Leaves Remaining:"+paid_leave);
		System.out.println("Sick Leaves Remaining:"+sick_leave);
		System.out.println("Casual Leaves Remaining:"+casual_leave);
		
	}
/*============method will check if leaves are available are not==========*/	
	boolean avail_leave(int no_of_leaves, char type_of_leave)
	{
		if(type_of_leave=='C')
		{
			if(no_of_leaves<=casual_leave)
			{
				
				casual_leave=casual_leave-no_of_leaves;
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(type_of_leave=='S')
		{
			if(no_of_leaves<=total_leaves)
			{
				sick_leave=sick_leave-no_of_leaves;
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(type_of_leave=='P')
		{
			if(no_of_leaves<=paid_leave)
			{
				paid_leave=paid_leave-no_of_leaves;
				return true;
			}
			else
			{
				
				return false;
			}
		}
		else
		{
			System.out.println("Sorry! Cant find record...");
			return false;
		}
	}
	/*============method will calculate salary==========*/	
	void calculate_salary()
	{
		double total_sallary;
		total_sallary= (basic+hra-pfa);
		System.out.println("Basic		 : "+basic);
		System.out.println("HRA  		+: "+hra);
		System.out.println("PF   		-: "+pfa);
		System.out.println("==================================================");
		System.out.println("Net Sallary	=: "+total_sallary);
	}
	/*=================================================================================*/	
	void print_leave_details()
	{
		System.out.println("Total Leaves Remaining:"+(casual_leave+paid_leave+sick_leave));	
		System.out.println("Casual Leaves:"+casual_leave);
		System.out.println("Paid Leaves  :"+paid_leave);
		System.out.println("Sick Leaves  :"+sick_leave);
	}
	/*=================================================================================*/
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		int temp=0,temp2;	// creating temporary variable for switch case...
		char leave_type;	// creating temporary variable for type of leave expected
		Scanner scan=new Scanner(System.in);
		//BufferedReader obj= new BufferedReader(new InputStreamReader(System.in));
		
		PermanentEmp b1 =new PermanentEmp(101,"Pranav",5000);  	// entry record setting default value
		PermanentEmp b2 =new PermanentEmp(102,"Amit",3500);		//
		PermanentEmp b3 =new PermanentEmp(103,"Pramod",12000);	//
	//	System.out.println("Name: "+b1.empName+"\nEmp.Id: "+b1.empId+"\nLeaves remaining: "+(b1.casual_leave+b1.paid_leave+b1.sick_leave));
		
		System.out.println("Enter Employee ID:");
		temp=scan.nextInt();
		System.out.println("==================================================");
		switch(temp)// choose on basis of emp id
		{
			case 101:System.out.println("Name: "+b1.empName+"\nEmp.Id: "+b1.empId+"\nLeaves remaining: "+(b1.casual_leave+b1.paid_leave+b1.sick_leave));b1.calculate_salary();break;
			case 102:System.out.println("Name: "+b2.empName+"\nEmp.Id: "+b2.empId+"\nLeaves remaining: "+(b2.casual_leave+b2.paid_leave+b2.sick_leave));b2.calculate_salary();break;
			case 103:System.out.println("Name: "+b3.empName+"\nEmp.Id: "+b3.empId+"\nLeaves remaining: "+(b3.casual_leave+b3.paid_leave+b3.sick_leave));b3.calculate_salary();break;
			default: System.out.println("Invalid Employee ID !");break;//id not found
		}
		System.out.println("==================================================");
		System.out.println("Expected leaves:\n C: Casual leaves\n P: Paid Leaves\n S: Sick Leaves");
		leave_type=scan.next(".").charAt(0);
		if((leave_type=='P')||(leave_type=='C')||(leave_type=='S'))
		{
			System.out.println("No Of leaves:");
			temp2=scan.nextInt();
			switch (temp)// choose on basis of emp id
			{
				case 101: if(b1.avail_leave(temp2, leave_type)){System.out.println("Leave Approved.");b1.print_leave_details();}else{System.out.println("Sorry! No Leaves Available...");};break;
				case 102: if(b2.avail_leave(temp2, leave_type)){System.out.println("Leave Approved.");b2.print_leave_details();}else{System.out.println("Sorry! No Leaves Available...");};break;
				case 103: if(b3.avail_leave(temp2, leave_type)){System.out.println("Leave Approved.");b3.print_leave_details();}else{System.out.println("Sorry! No Leaves Available...");};break;
				
			}
			System.out.println("==================================================");
		}
		else
		{
			System.out.println("Sorry! Cant find record...");
			System.out.println("==================================================");
		}


	}

}
