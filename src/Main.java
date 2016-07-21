import java.util.ArrayList;
import java.util.HashSet;

public class Main 
{
	//private static HashSet<String> set = new HashSet<String>();
	private static ArrayList<String> _sentences = new ArrayList<String>();
	private static ArrayList<String> _sentencesFinal = new ArrayList<String>();
	private static String _passage = "";
	private static double[] _multi2;
	
	public static ArrayList<String> seperator(String passage)
	//Returns an arraylist of sentences.
	{
		passage = passage + "   ";
		_passage = passage;
		//3 spaces. Done to make sure i+2 exists for the last period being at i;
		//corrected finally in .trim();
		int index = 0;
		for(int i = 0; i < passage.length(); i++)//iterator.
		{
			if(passage.charAt(i) == '.')//detects fullstop.
			{
				if(passage.charAt(i+1) != ' ')
				//if the char next to the priod is not a space,
				//it's probably a decimal, or a non sentence-ending period.
				{
					if(Character.toString(passage.charAt(i+1)).matches("[^A-Za-z0-9 ]"))
					//buuuut it might be a special char.
					{
						_sentences.add(passage.substring(index, i+1));
						index = i+1;
					}
				}
				else
				//Space after the period.
				{
					char a = passage.charAt(i+2);
					if(Character.toString(a).matches("[^A-Za-z0-9 ]"))
					//is a special char	
					{
						_sentences.add(passage.substring(index, i+1));//#pass
						index = i+2;
					}
					else if(Character.isUpperCase(a))
					//char after space is not lower case;
					{
						//add exceptions for Mr., Ms. etc.
						//for now, let's assume every period followed by a capital letter is a senrence ender.
						{
							_sentences.add(passage.substring(index, i+1));//#pass
							index = i+2;
						}
					}
					else
					{
						
					}
				}
			}
		}
		_sentences.add(passage.substring(index).trim());
		return _sentences;
	}

	public static ArrayList<String> wordFinder(String sentence)
	{
		String[] wordsArray = sentence.split(" ");
		for(int i = 0; i<wordsArray.length; i++)
		{
			wordsArray[i] = wordsArray[i].replaceAll("[^\\w]", "");
		}
		ArrayList<String> words = new ArrayList<String>();
		for(String a:wordsArray)
		{
			words.add(a);
		}
		return words;
	}
	
	public static double[] counter(ArrayList<String> sentences)
	{ 
		_multi2 = new double[_sentences.size()];
		ArrayList<String> exclude = new ArrayList<String>();
		exclude.add("a");
		exclude.add("an");
		exclude.add("and");
		exclude.add("the");
		exclude.add("to");
		exclude.add("from");
		exclude.add("with");
		exclude.add("without");
		exclude.add("as");
		exclude.add("in");
		exclude.add("on");
		exclude.add("is");
		exclude.add("was");
		exclude.add("are");
		exclude.add("were");
		exclude.add("he");
		exclude.add("she");
		exclude.add("for");
		exclude.add("they");
		exclude.add("when");
		exclude.add("where");
		exclude.add("who");
		exclude.add("what");
		exclude.add("how");
		exclude.add("can");
		
		
//		ArrayList<String> setTwo = new ArrayList<String>();
//		
//		for(String sentence:_sentences)
//		{
//			for(String word: wordFinder(sentence))
//			{
//				set.add(word);
//				setTwo.add(word);
//			}
//		}
//		System.out.println(set.size());
//		System.out.println(setTwo.size());
		
		for(int x = 0; x < _sentences.size(); x++)
		{
			//System.out.println("ayy");
			String sentence = _sentences.get(x);
			int i = 0;
			for(String word: wordFinder(sentence))
			{
				if(exclude.contains(word))
				{
					
				}
				else
				{
					for(String a: wordFinder(_passage))
					{
						//System.out.println("two");
						if(word.equals(a))
						{
							//System.out.println("three");
							i++;
						}
					}
				}
				//System.out.println("one");
				
			}
			double index = (double)i;
			double wordNo = ((double)wordFinder(sentence).size());
			
			ArrayList<String> wordCo = new ArrayList<String>();
			
			for(String word:wordFinder(sentence))
			{
				if(exclude.contains(word) == false)
				{
					wordCo.add(word);
				}
			}
			//_multi2[x] = index/((double)(wordCo.size()));
			//_multi2[x] = index;
			_multi2[x] = index/((double)(wordFinder(sentence).size()));
			//_multi2[x] = index-wordFinder(sentence).size();
		}
		return _multi2;
	}

	public static ArrayList<String> orderedSentences(double[] set)
	{
		
		return null;
	}
}
