package Employee;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/*=================================================================================*/
public class TemporaryEmp extends Employee{
	private static final boolean True = false;
	
	
	TemporaryEmp(int id,String Name,double sal)
	{
	
		empId=id;
		empName=Name;
		total_salary=sal;
		total_leaves=5;
		
	}
	/*=================================================================================*/
	void calculate_balance_leaves()
	{
		
		System.out.println("Paid Leaves Remaining:"+total_leaves);
				
	}
	/*=================================================================================*/
	void print_leave_details()
	{
		System.out.println("Total Leaves Remaining:"+total_leaves);	
		
	}
	/*=================================================================================*/
	void calculate_salary()
	{
	
		System.out.println("Basic		 : "+total_salary);
		System.out.println("HRA  		+:0.0 ");
		System.out.println("PF   		-:0.0 ");
		System.out.println("==================================================");
		System.out.println("Net Sallary	=: "+total_salary);
	}
	/*==========this method will handle leaves employee can have ================*/
	boolean avail_leave(int no_of_leaves, char type_of_leave)
	{
		if(type_of_leave=='C')// no casual leaves allowed for temp worker
		{		
					return false;
		}	
		else if(type_of_leave=='S')// sick leaves allowed
		{
				if(no_of_leaves<=total_leaves)
				{
					total_leaves=total_leaves-no_of_leaves;
					return true;
				}	
				else
				{
					return false;
				}
			
		}
		else if(type_of_leave=='P')// no paid leaves allowed for temp worker
		{	
				
				return false;
			
		}
		else
		{
			System.out.println("Sorry! Cant find record...");  // type of leave mismatched
			return false;
		}
	}
	/*=================================================================================*/
	public static void main(String[] args)throws IOException {
		
		int temp=0,temp2;	// creating temporary variable for switch case...
		char leave_type;	// creating temporary variable for type of leave expected
		Scanner scan=new Scanner(System.in);
			
		TemporaryEmp b1 =new TemporaryEmp(201,"Sidharth",3000);  	// entry record setting default value
		TemporaryEmp b2 =new TemporaryEmp(202,"Vinod",3000);		//
		TemporaryEmp b3 =new TemporaryEmp(303,"Jitendra",5000);	//
	//	System.out.println("Name: "+b1.empName+"\nEmp.Id: "+b1.empId+"\nLeaves remaining: "+(b1.casual_leave+b1.paid_leave+b1.sick_leave));
		
		System.out.println("Enter Employee ID:");
		temp=scan.nextInt();
		System.out.println("==================================================");
		switch(temp)// choose on basis of emp id
		{
			case 201:System.out.println("Name: "+b1.empName+"\nEmp.Id: "+b1.empId+"\nLeaves remaining: "+(b1.total_leaves));b1.calculate_salary();break;
			case 202:System.out.println("Name: "+b2.empName+"\nEmp.Id: "+b2.empId+"\nLeaves remaining: "+(b2.total_leaves));b2.calculate_salary();break;
			case 203:System.out.println("Name: "+b3.empName+"\nEmp.Id: "+b3.empId+"\nLeaves remaining: "+(b3.total_leaves));b3.calculate_salary();break;
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
				case 201: if(b1.avail_leave(temp2, leave_type)){System.out.println("Leave Approved.");b1.print_leave_details();}else{System.out.println("Sorry! No Leaves Available...");};break;
				case 202: if(b2.avail_leave(temp2, leave_type)){System.out.println("Leave Approved.");b2.print_leave_details();}else{System.out.println("Sorry! No Leaves Available...");};break;
				case 203: if(b3.avail_leave(temp2, leave_type)){System.out.println("Leave Approved.");b3.print_leave_details();}else{System.out.println("Sorry! No Leaves Available...");};break;
				
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
