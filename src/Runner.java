import java.util.ArrayList;

public class Runner 
{
	public static void main(String[] args)
	{
		String passage = "A lone gunman killed three law enforcement officers and wounded three others in Baton Rouge on Sunday morning, less than two weeks after the death of an African-American man at the hands of Baton Rouge police. The shootings occurred when police responded to a 911 call that a man, dressed in black and armed with what appeared to be an assault-style rifle, was walking near a shopping plaza about a mile from police headquarters. The deaths shocked a nation already on edge over recent killings by police, a run of violence that began July 5 in Baton Rouge and which has now left 10 dead, including eight law enforcement officers and two residents killed by police. Two city policemen and one sheriff's deputy were fatally wounded, and another sheriff's deputy was critically injured, said Col. Michael Edmonson, the superintendent of the Louisiana State Police at an afternoon news conference. The alleged gunman, who was shot and killed during the exchange of gunfire, was later identified as Gavin Long, an African-American resident of Kansas City, Missouri, who turned 29 on Sunday,and was in Baton Rouge celebrating his birthday, according to relatives. In the spring of 2012, Long was named to the dean's list at the University of Alabama, where he attended for one semester, university officials said.";
		ArrayList<String> ayy = Main.seperator(passage);
		for(int i = 0; i < ayy.size(); i++)
		{
			System.out.println(ayy.get(i));
		}
		
//		for(String a:Main.wordFinder(ayy.get(0)))
//		{
//			System.out.println(a);
//		}
		
		double[] a = Main.counter(ayy);
		for(int i = 0; i< a.length; i++)
		{
			System.out.println(a[i]);
		}
	}
}