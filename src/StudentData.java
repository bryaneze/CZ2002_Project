import java.util.*;
import java.util.Map.Entry;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class StudentData {
	public static void main (String args[]) throws FileNotFoundException
	{
		String[][] test = new String[100][5];
		String a,b,c,d,e,f;
		int y = 0;
		int z =0;
		Scanner x = new Scanner(new File("StudentData.txt"));
		Scanner abc = new Scanner(System.in);
		x.useDelimiter("[,\n]");
		while(x.hasNext())
		{		
				a=x.next().trim();
				b=x.next().trim();
				c=x.next().trim();
				d=x.next().trim();
				e=x.next().trim();
				test[y][0] = a;
				test[y][1] = b;
				test[y][2] = c;
				test[y][3] = d;
				test[y][4] = e;
				y++;
				
		}
		
		/*System.out.println("Please input the name of the Student : ");
		String name = abc.nextLine();
		System.out.println("Get classes");
		getClasses(name,test);
		System.out.println("");
		System.out.println("Get Student Classes");
		getStudentsClass("J01",test);
		System.out.println("Get Student");
		getStudent(test);
		System.out.println("");
		test= dropClass("A01","U01",test);
		*/
		/*
		for(y = 0;y<16;y++)
		{
			for(z=0;z<5;z++)
			{
				System.out.print(test[y][z] + " ");
			}
			System.out.println("");
			
		}
		*/


	}
	
	public static void getClasses (String Name, String student_list[][]) // Get a student's classes
	{
		int x,y,z = 0;
		for(x=0;x<100;x++)
		{
			if(student_list[x][0] == null)
				break;
			if(student_list[x][0].equals(Name))
			{
				System.out.println("You are taking the following courses.");
				
				String [] temp = student_list[x][4].split("-");
				y=temp.length;
				for(z=0;z<y;z++)
				{
					System.out.println(temp[z]);
				}
				break;
			}
		}
	}
	
	public static void getStudentsClass ( String index , String student_list[][]) // Get a list of students that belongs to a class
	{
		int i =0;
		int x = 0;
		int y = 0;
		boolean t = true;
		String[] temp = new String[5];
		String[] names = new String[5];
		while(t)
		{
			for(int a = 0; a<3;a++)
			{	
				temp = student_list[a][4].split("-");
				x = temp.length;
				for(i=0;i<x;i++)
				{
					if(temp[i].equals(index))
					{
						names[y]=student_list[a][1];
						y++;
					}
				}
			}
			break;
		}
		for(x=0;x<y;x++)
		{
			System.out.println(names[x]);
		}
	}
	
	public static void getStudent (String student_list[][])
	{
		int x,y = 0;
		for(x = 0; x<100;x++)
		{
			if(student_list[x][1] == null)
				break;
			System.out.println(student_list[x][1]);
		}
	}
	
	public static String[][] dropClass (String class_index, String student_num, String student_list[][])
	{
		int x,y,z=0;
		int a = 0;
		String temp = "";
		for(x=0;x<100;x++)
		{
			if(student_list[x][0]== null)
				break;
			if(student_list[x][0].equals(student_num))
			{
				String [] temp1 = student_list[x][4].split("-");
				y = temp1.length;
				for(z=0;z<y;z++)
				{
					if(temp1[z].equals(class_index))
					{					
						System.out.println("You have dropped "+class_index);
						a=1;
					}
					else
					{
						if(z==(y-1))
						{
							temp = temp+temp1[z];
							break;
						}                                                                          
						temp = temp+temp1[z]+"-";
						
					}
				}				
				student_list[x][4] = temp;
			}
			
		}
		if(a==1)
		{
			return student_list;
		}
		System.out.println("You are not registered in "+class_index);
		return student_list;
	}
	public static String[][] addStudent(String Name,String Password,String Gender,String m_num,String Nationality, String student_list[][])
	{
		int x,y=0;
		
		for(x=0;x<100;x++)
		{
			if(student_list[x][0] == null)
			{
				student_list[x][0] = m_num;
				student_list[x][1] = Name;
				student_list[x][2] = Gender;
				student_list[x][3] = Nationality;
				student_list[x][4] = "NULL";
				System.out.println(Name+" has been added.");
				break;			
			}
			if(student_list[x][0].equals(m_num))
			{
				System.out.println("Error! Matriculation Number already existed");
				return student_list;
			}
			
		}
		return student_list;
	}
	
	public static String[][] swapIndex (String current_course_index, String future_course_index, String m_num, String [][] student_list)
	{
		int x,y,z=0;
		int a,b=0;
		for(x =0; x<100;x++)
		{
			if(student_list[x][0]==null) // No such m_num;
			{
				System.out.println("Error! Invalid Matriculation Number");
				return student_list;
			}
			if(student_list[x][0].equals(m_num))
			{
				String [] temp = student_list[x][4].split("-");
				y=temp.length;			
				for(a=0;a<y;a++)
				{
					if(temp[a].equals(current_course_index))
					{
						b=1;
					}
					if(b!=1)
					{
						System.out.println("You are not registered to "+current_course_index);
						return student_list;
					}
				}
				student_list[x][4] = "";
				for(z=0;z<y;z++)
				{
					if(temp[z].equals(current_course_index))
					{
						temp[z] = future_course_index;
					}
					if(z==(y-1))
					{
						student_list[x][4]= student_list[x][4]+"-"+temp[z];
						return student_list;
					}
					if(z==0)
					{
						student_list[x][4] = temp[0];
						continue;
					}
					student_list[x][4] = student_list[x][4]+"-"+temp[z];
				}
			}
		}
		return student_list;
	}
	
	public static String[][] addClass (String class_index, String student_num, String student_list[][], String course_data[][] )
	{
		boolean a = false;
		boolean b = false;
		boolean c = false;
		String a1 ="";
		String [] new_class_index_timings = new String[3];
		int e,f,g=0;
		int x,y,z=0;
		// get timing of the new class_index
		for(x=0;x<100;x++)
		{
			if(course_data[x][2] == null)
			{
				System.out.println("There are no such index : "+class_index);
				return student_list;
			}
				
			if(course_data[x][2].equals(class_index)) // Get the class_index timings that we want to add 
			{
				new_class_index_timings[0] = course_data[x][4]; 
				new_class_index_timings[1] = course_data[x][5]; 
				new_class_index_timings[2] = course_data[x][6]; 
				break;
			}
		}
		for(x=0;x<100;x++)
		{
			if(student_list[x][0]==null)
			{
				break;
			}
			if(student_list[x][0].equals(student_num))
			{
				a1= class_index.substring(0,1); // return first character of the class
				String [] temp = student_list[x][4].split("-");
				y = temp.length;
				for(z=0;z<y;z++) // Check if similar index already exist
				{
					if(temp[0].contains(a1))
					{
						System.out.println("You are already taking this course with another index");
						return student_list;
					}
				}
				// Check clashes
				
				for(z=0;z<y;z++)
				{
					for(e=0;e<100;e++)
					{
						if(course_data[e][0] == null)
						{
							break;
						}
						if(course_data[e][2].equals(temp[z]))
						{
							System.out.println("a");
							a= CourseData.checkClash(course_data[e][4],new_class_index_timings[0]); // 4 & 5 & 6
							System.out.println("b");
							b= CourseData.checkClash(course_data[e][5],new_class_index_timings[1]); // 4 & 5 & 6
							System.out.println("c");
							c= CourseData.checkClash(course_data[e][6],new_class_index_timings[2]); // 4 & 5 & 6
							if(a==true || b==true || c==true)
							{
								System.out.println("You can't take this index as it clashes with "+course_data[e][2]);
								return student_list;
							}
						}
					}

				}
				student_list[x][4] = student_list[x][4]+"-"+class_index;
			}
		}
		return student_list;
	}
}


