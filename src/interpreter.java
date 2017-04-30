import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

// I am officially done with multiplication, addition, subtraction, and, not, equals, and the lessThan function and I am also officially done with the if functions.  

//I still need to work on division, remainder and the let...end function.....
public class interpreter
{

	public static void interpreter(String input, String output)
			throws IOException
	{

		Scanner x;
		x = new Scanner(new File(input));
		String operation;
		Stack<String> myStack = new Stack<String>();

		HashMap<String, ArrayList<String>> mapString = new HashMap<String, ArrayList<String>>();
		HashMap<String, ArrayList<String>> mapString2;
		ArrayList<HashMap<String, ArrayList<String>>> mapStringList = new ArrayList<>();

		mapStringList.add(mapString);

		HashMap<String, String> map1 = new HashMap<String, String>();
		HashMap<String, String> map2;

		int countMapString = 0;

		int countLet = 0;
		int countLet1 = 0;
		int countEnd = 0;
		int countMap = 0;

		ArrayList<HashMap<String, String>> list2 = new ArrayList<HashMap<String, String>>();

		list2.add(map1);

		ArrayList<Stack<String>> list = new ArrayList<>();
		list.add(myStack);

		ArrayList<String> list4 = new ArrayList<String>();

		while (x.hasNext())
		{

			String a = x.next();
			list4.add(a);

		}
		for (int i = 0; i < list4.size(); i++)
		{
			System.out.println("The value i is: " + i);
			String a = list4.get(i);
			System.out.println("String a is: " + a);
			if (a.equals(":error:"))
			{

				list.get(countLet).push(":error:");

			}
			else if (a.equals(":true:") || a.equals(":false:"))
			{

				list.get(countLet).push(a);

				System.out
						.println("Now that we have a boolean value and it is: "
								+ a);

			}

			else if (a.equals("push"))
			{

				String b = list4.get(i + 1);
				i++;
				System.out.println("String b is: " + b);

				if (Character.isLetter(b.charAt(0)))
				{
					list.get(countLet).push(b);
				}

				else if (b.matches("[0-9]+") && Integer.parseInt(b) > 0)
				{

					list.get(countLet).push(b);

					System.out.println("Now that we have a number and it is: "
							+ b);

				}
				else if (b.equals("0") || b.equals("-0"))
				{
					list.get(countLet).push("0");

				}
				else if (b.charAt(0) == '-' && Character.isDigit(b.charAt(1)))
				{

					System.out
							.println("Now that we have a negative number and it is:   "
									+ "-"
									+ Integer.toString(Math.abs(Integer
											.parseInt(b))));

					System.out.println(Math.abs(Integer.parseInt(b)));

					list.get(countLet).push(
							"-"
									+ Integer.toString(Math.abs(Integer
											.parseInt(b))));

				}
				else if (b.charAt(0) == '"')
				{

					if (b.charAt(b.length() - 1) == '"')
					{
						list.get(countLet).push(b);
					}

					else if (b.charAt(b.length() - 1) != '"')
					{
						String c = list4.get(i + 1);
						i++;
						if (c.charAt(c.length() - 1) == '"')
						{
							list.get(countLet).push(b + " " + c);
						}
						else if (c.charAt(c.length() - 1) != '"')
						{
							String d = list4.get(i + 1);
							i++;
							if (d.charAt(d.length() - 1) == '"')
							{
								list.get(countLet).push(b + " " + c + " " + d);
							}
							else if (d.charAt(d.length() - 1) != '"')
							{
								String f = list4.get(i + 1);
								i++;
								if (f.charAt(f.length() - 1) == '"')
								{
									list.get(countLet).push(
											b + " " + c + " " + d + " " + f);
								}
								else if (f.charAt(f.length() - 1) != '"')
								{
									String g = list4.get(i + 1);
									i++;
									if (g.charAt(g.length() - 1) == '"')
									{
										list.get(countLet).push(
												b + " " + c + " " + d + " " + f
														+ " " + g);
									}
									else if (g.charAt(g.length() - 1) != '"')
									{
										String h = list4.get(i + 1);
										i++;
										if (h.charAt(h.length() - 1) == '"')
										{
											list.get(countLet).push(
													b + " " + c + " " + d + " "
															+ f + " " + g + " "
															+ h);
										}
										else if (h.charAt(h.length() - 1) != '"')
										{
											String j = list4.get(i + 1);
											i++;

											if (j.charAt(j.length() - 1) == '"')
											{
												list.get(countLet).push(
														b + " " + c + " " + d
																+ " " + f + " "
																+ g + " " + h
																+ " " + j);

											}
										}
									}
								}
							}
						}

					}

					// System.out.println(b.substring(1,b.length()-1));

				}
				else
				{
					list.get(countLet).push(":error:");

				}

			}

			// Now Im officially done with addition.
			else if (a.equals("add"))
			{

				if (list.get(countLet).size() == 1
						|| list.get(countLet).size() == 0)
				{
					list.get(countLet).push(":error:");

				}
				// These lines of code checks if the name can be found in the
				// list2.get(countMap).
				else if (Character
						.isLetter(list.get(countLet).peek().charAt(0))
						&& list2.get(countMap).containsKey(
								list.get(countLet).peek()))
				{
					String m = list.get(countLet).peek();

					String m1 = list2.get(countMap).get(
							list.get(countLet).peek());
					// This is the first test case here.
					if (m1.matches("[0-9]+")
							|| (m1.charAt(0) == '-' && Character.isDigit(m1
									.charAt(1))))
					{
						list.get(countLet).pop();
						String n = list.get(countLet).peek();
						if (Character.isLetter(list.get(countLet).peek()
								.charAt(0))
								&& list2.get(countMap).containsKey(
										list.get(countLet).peek()))
						{

							String n1 = list2.get(countMap).get(
									list.get(countLet).peek());
							if (n1.matches("[0-9]+")
									|| (n1.charAt(0) == '-' && Character
											.isDigit(n1.charAt(1))))
							{
								list.get(countLet).pop();
								String q = Integer.toString(Integer
										.parseInt(n1) + Integer.parseInt(m1));
								list.get(countLet).push(q);

							}
							else if (!n1.matches("[0-9]+")
									&& n1.charAt(0) != '-')
							{
								list.get(countLet).push(m);
								list.get(countLet).push(":error:");

							}
						}
						else if (n.matches("[0-9]+")
								|| (n.charAt(0) == '-' && Character.isDigit(n
										.charAt(1))))
						{
							System.out
									.println("The second number is an integer");
							String w = Integer.toString(Integer.parseInt(n)
									+ Integer.parseInt(m1));
							list.get(countLet).pop();
							System.out
									.println("The result of this addition is: "
											+ w);
							list.get(countLet).push(w);

						}

						// This corresponds to the if statement above.

					}
					else if (!m1.matches("[0-9]+") && m1.charAt(0) != '-')
					{
						list.get(countLet).push(":error:");

					}

				}

				else if (!list.get(countLet).peek().matches("[0-9]+")
						&& list.get(countLet).peek().charAt(0) != '-')
				{
					list.get(countLet).push(":error:");
					System.out.println("The top element is not a number");

				}

				else if (list.get(countLet).peek().matches("[0-9]+")
						|| (list.get(countLet).peek().charAt(0) == '-' && Character
								.isDigit(list.get(countLet).peek().charAt(1))))
				{
					String b = list.get(countLet).pop();
					System.out.println("After popping we have: " + b);

					if (Character.isLetter(list.get(countLet).peek().charAt(0))
							&& list2.get(countMap).containsKey(
									list.get(countLet).peek()))
					{
						String c = list2.get(countMap).get(
								list.get(countLet).peek());
						if (!c.matches("[0-9]+") && c.charAt(0) != '-')
						{
							list.get(countLet).push(b);
							list.get(countLet).push(":error:");
						}
						else if (c.matches("[0-9]+")
								|| (c.charAt(0) == '-' && Character.isDigit(c
										.charAt(1))))
						{
							// This is the
							System.out.println("The second number is: "
									+ list2.get(countMap).get(
											list.get(countLet).peek()));
							list.get(countLet).pop();
							String q = Integer.toString(Integer.parseInt(c)
									+ Integer.parseInt(b));
							System.out.println("The addition result is: " + q);
							list.get(countLet).push(q);

						}
					}
					else if ((!list.get(countLet).peek().matches("[0-9]+"))
							&& list.get(countLet).peek().charAt(0) != '-')
					{
						list.get(countLet).push(b);
						list.get(countLet).push(":error:");

					}

					else if (list.get(countLet).peek().matches("[0-9]+")
							|| (list.get(countLet).peek().charAt(0) == '-' && Character
									.isDigit(list.get(countLet).peek()
											.charAt(1))))
					{
						String c = list.get(countLet).pop();

						String d = Integer.toString(Integer.parseInt(c)
								+ Integer.parseInt(b));
						list.get(countLet).push(d);
						System.out
								.println("After implementing the addition function and now that we have: "
										+ d);

					}

				}
			} // and this is the end of the subtraction function.

			else if (a.equals("sub"))
			{

				if (list.get(countLet).size() == 1
						|| list.get(countLet).size() == 0)
				{
					list.get(countLet).push(":error:");

				}
				// These lines of code checks if the name can be found in the
				// list2.get(countMap).
				else if (Character
						.isLetter(list.get(countLet).peek().charAt(0))
						&& list2.get(countMap).containsKey(
								list.get(countLet).peek()))
				{
					String m = list.get(countLet).peek();

					String m1 = list2.get(countMap).get(
							list.get(countLet).peek());
					// This is the first test case here.
					if (m1.matches("[0-9]+")
							|| (m1.charAt(0) == '-' && Character.isDigit(m1
									.charAt(1))))
					{
						list.get(countLet).pop();
						String n = list.get(countLet).peek();
						if (Character.isLetter(list.get(countLet).peek()
								.charAt(0))
								&& list2.get(countMap).containsKey(
										list.get(countLet).peek()))
						{

							String n1 = list2.get(countMap).get(
									list.get(countLet).peek());
							if (n1.matches("[0-9]+")
									|| (n1.charAt(0) == '-' && Character
											.isDigit(n1.charAt(1))))
							{
								list.get(countLet).pop();
								String q = Integer.toString(Integer
										.parseInt(n1) - Integer.parseInt(m1));
								list.get(countLet).push(q);

							}
							else if (!n1.matches("[0-9]+")
									&& n1.charAt(0) != '-')
							{
								list.get(countLet).push(m);
								list.get(countLet).push(":error:");

							}
						}
						else if (n.matches("[0-9]+")
								|| (n.charAt(0) == '-' && Character.isDigit(n
										.charAt(1))))
						{
							System.out
									.println("The second number is an integer");
							String w = Integer.toString(Integer.parseInt(n)
									- Integer.parseInt(m1));
							list.get(countLet).pop();
							System.out
									.println("The result of this addition is: "
											+ w);
							list.get(countLet).push(w);

						}

						// This corresponds to the if statement above.

					}
					else if (!m1.matches("[0-9]+") && m1.charAt(0) != '-')
					{
						list.get(countLet).push(":error:");

					}

				}

				else if (!list.get(countLet).peek().matches("[0-9]+")
						&& list.get(countLet).peek().charAt(0) != '-')
				{
					list.get(countLet).push(":error:");
					System.out.println("The top element is not a number");

				}

				else if (list.get(countLet).peek().matches("[0-9]+")
						|| (list.get(countLet).peek().charAt(0) == '-' && Character
								.isDigit(list.get(countLet).peek().charAt(1))))
				{
					String b = list.get(countLet).pop();
					System.out.println("After popping we have: " + b);

					if (Character.isLetter(list.get(countLet).peek().charAt(0))
							&& list2.get(countMap).containsKey(
									list.get(countLet).peek()))
					{
						String c = list2.get(countMap).get(
								list.get(countLet).peek());
						if (!c.matches("[0-9]+") && c.charAt(0) != '-')
						{
							list.get(countLet).push(b);
							list.get(countLet).push(":error:");
						}
						else if (c.matches("[0-9]+")
								|| (c.charAt(0) == '-' && Character.isDigit(c
										.charAt(1))))
						{
							// This is the
							System.out.println("The second number is: "
									+ list2.get(countMap).get(
											list.get(countLet).peek()));
							list.get(countLet).pop();
							String q = Integer.toString(Integer.parseInt(c)
									- Integer.parseInt(b));
							System.out.println("The addition result is: " + q);
							list.get(countLet).push(q);

						}
					}
					else if ((!list.get(countLet).peek().matches("[0-9]+"))
							&& list.get(countLet).peek().charAt(0) != '-')
					{
						list.get(countLet).push(b);
						list.get(countLet).push(":error:");

					}

					else if (list.get(countLet).peek().matches("[0-9]+")
							|| (list.get(countLet).peek().charAt(0) == '-' && Character
									.isDigit(list.get(countLet).peek()
											.charAt(1))))
					{
						String c = list.get(countLet).pop();

						String d = Integer.toString(Integer.parseInt(c)
								- Integer.parseInt(b));
						list.get(countLet).push(d);
						System.out
								.println("After implementing the addition function and now that we have: "
										+ d);

					}

				}
			} // and this is the end of the subtraction function.

			else if (a.equals("mul"))
			{

				if (list.get(countLet).size() == 1
						|| list.get(countLet).size() == 0)
				{
					list.get(countLet).push(":error:");

				}
				// These lines of code checks if the name can be found in the
				// list2.get(countMap).
				else if (Character
						.isLetter(list.get(countLet).peek().charAt(0))
						&& list2.get(countMap).containsKey(
								list.get(countLet).peek()))
				{
					String m = list.get(countLet).peek();

					String m1 = list2.get(countMap).get(
							list.get(countLet).peek());
					// This is the first test case here.
					if (m1.matches("[0-9]+")
							|| (m1.charAt(0) == '-' && Character.isDigit(m1
									.charAt(1))))
					{
						list.get(countLet).pop();
						String n = list.get(countLet).peek();
						if (Character.isLetter(list.get(countLet).peek()
								.charAt(0))
								&& list2.get(countMap).containsKey(
										list.get(countLet).peek()))
						{

							String n1 = list2.get(countMap).get(
									list.get(countLet).peek());
							if (n1.matches("[0-9]+")
									|| (n1.charAt(0) == '-' && Character
											.isDigit(n1.charAt(1))))
							{
								list.get(countLet).pop();
								String q = Integer.toString(Integer
										.parseInt(n1) * Integer.parseInt(m1));
								list.get(countLet).push(q);

							}
							else if (!n1.matches("[0-9]+")
									&& n1.charAt(0) != '-')
							{
								list.get(countLet).push(m);
								list.get(countLet).push(":error:");

							}
						}
						else if (n.matches("[0-9]+")
								|| (n.charAt(0) == '-' && Character.isDigit(n
										.charAt(1))))
						{
							System.out
									.println("The second number is an integer");
							String w = Integer.toString(Integer.parseInt(n)
									* Integer.parseInt(m1));
							list.get(countLet).pop();
							System.out
									.println("The result of this addition is: "
											+ w);
							list.get(countLet).push(w);

						}

						// This corresponds to the if statement above.

					}

					else if (!m1.matches("[0-9]+") && m1.charAt(0) != '-')
					{
						list.get(countLet).push(":error:");

					}

				}

				else if (!list.get(countLet).peek().matches("[0-9]+")
						&& list.get(countLet).peek().charAt(0) != '-')
				{
					list.get(countLet).push(":error:");
					System.out.println("The top element is not a number");

				}

				else if (list.get(countLet).peek().matches("[0-9]+")
						|| (list.get(countLet).peek().charAt(0) == '-' && Character
								.isDigit(list.get(countLet).peek().charAt(1))))
				{
					String b = list.get(countLet).pop();
					System.out.println("After popping we have: " + b);

					if (Character.isLetter(list.get(countLet).peek().charAt(0))
							&& list2.get(countMap).containsKey(
									list.get(countLet).peek()))
					{
						String c = list2.get(countMap).get(
								list.get(countLet).peek());
						if (!c.matches("[0-9]+") && c.charAt(0) != '-')
						{
							list.get(countLet).push(b);
							list.get(countLet).push(":error:");
						}
						else if (c.matches("[0-9]+")
								|| (c.charAt(0) == '-' && Character.isDigit(c
										.charAt(1))))
						{
							// This is the
							System.out.println("The second number is: "
									+ list2.get(countMap).get(
											list.get(countLet).peek()));
							list.get(countLet).pop();
							String q = Integer.toString(Integer.parseInt(c)
									* Integer.parseInt(b));
							System.out.println("The addition result is: " + q);
							list.get(countLet).push(q);

						}
					}
					else if ((!list.get(countLet).peek().matches("[0-9]+"))
							&& list.get(countLet).peek().charAt(0) != '-')
					{
						list.get(countLet).push(b);
						list.get(countLet).push(":error:");

					}

					else if (list.get(countLet).peek().matches("[0-9]+")
							|| (list.get(countLet).peek().charAt(0) == '-' && Character
									.isDigit(list.get(countLet).peek()
											.charAt(1))))
					{
						String c = list.get(countLet).pop();

						String d = Integer.toString(Integer.parseInt(c)
								* Integer.parseInt(b));
						list.get(countLet).push(d);
						System.out
								.println("After implementing the addition function and now that we have: "
										+ d);

					}

				}
			} // and this is the end of the subtraction function.

			// Now I'm officially doen with my division codes
			else if (a.equals("div"))
			{

				if (list.get(countLet).size() == 1
						|| list.get(countLet).size() == 0)
				{
					list.get(countLet).push(":error:");
				}

				else if (Character
						.isLetter(list.get(countLet).peek().charAt(0))
						&& list2.get(countMap).containsKey(
								list.get(countLet).peek()))
				{
					String m = list.get(countLet).peek();
					String m1 = list2.get(countMap).get(
							list.get(countLet).peek());
					System.out.println("The first number being peeked out is: "
							+ m1);
					// This is the first test case here.
					if (m1.equals("0"))
					{

						list.get(countLet).push(":error:");
						System.out
								.println("Now that an error literal is being pushed onto the stack");

					}
					else if (!m1.equals("0"))
					{

						if (!m1.matches("[0-9]+") && m1.charAt(0) != '-')
						{
							list.get(countLet).push(":error:");

						}
						else if (m1.matches("[0-9]+") || m1.charAt(0) == '-')
						{
							list.get(countLet).pop();
							// }

							if (Character.isLetter(list.get(countLet).peek()
									.charAt(0))
									&& list2.get(countMap).containsKey(
											list.get(countLet).peek()))
							{
								String n = list.get(countLet).peek();
								String n1 = list2.get(countMap).get(
										list.get(countLet).peek());
								if (n1.matches("[0-9]+") || n1.charAt(0) == '-')
								{
									System.out
											.println("Now that the second name is a number");
									System.out
											.println("The second number being popped out is: "
													+ list2.get(countMap).get(
															list.get(countLet)
																	.peek()));
									list.get(countLet).pop();

									String q = Integer.toString(Integer
											.parseInt(n1)
											/ Integer.parseInt(m1));
									System.out
											.println("The result of the division is:   "
													+ q);
									list.get(countLet).push(q);
								}
								else if (!n1.matches("[0-9]+")
										&& n1.charAt(0) != '-')
								{
									list.get(countLet).push(m);
									System.out
											.println("Now that the second name is not a number ");
									list.get(countLet).push(":error:");

								}

							}
							else if (list.get(countLet).peek()
									.matches("[0-9]+")
									|| list.get(countLet).peek().charAt(0) == '-')
							{

								String w = Integer.toString(Integer
										.parseInt(list.get(countLet).peek())
										/ Integer.parseInt(m));
								list.get(countLet).pop();
								System.out
										.println("The result of the subtraction is: "
												+ w);
								list.get(countLet).push(w);

							}
						}

					}
				}
				else if (!list.get(countLet).peek().matches("[0-9]+")
						&& list.get(countLet).peek().charAt(0) != '-')
				{
					list.get(countLet).push(":error:");
					System.out.println("The top element is not a number");

				}

				else if ((list.get(countLet).peek().matches("[0-9]+") || list
						.get(countLet).peek().charAt(0) == '-'))
				{
					String b = list.get(countLet).pop();
					System.out.println("After popping we have: " + b);
					if (b.equals("0"))
					{
						list.get(countLet).push(b);
						list.get(countLet).push(":error:");
					}
					else if (!b.equals("0"))
					{
						if (Character.isLetter(list.get(countLet).peek()
								.charAt(0))
								&& list2.get(countMap).containsKey(
										list.get(countLet).peek()))
						// This method checks if the map contains the
						// name.........
						{
							String c = list2.get(countMap).get(
									list.get(countLet).peek());
							// This is the
							System.out.println("The second number is: "
									+ list2.get(countMap).get(
											list.get(countLet).peek()));
							list.get(countLet).pop();
							String q = Integer.toString(Integer.parseInt(c)
									/ Integer.parseInt(b));
							System.out.println("The addition result is: " + q);
							list.get(countLet).push(q);

						}

						else if (list.get(countLet).peek().matches("[0-9]+")
								|| list.get(countLet).peek().charAt(0) == '-')
						{

							String c = list.get(countLet).pop();
							String d = Integer.toString(Integer.parseInt(c)
									/ Integer.parseInt(b));
							list.get(countLet).push(d);

						}
						else if (!list.get(countLet).peek().matches("[0-9]+")
								&& list.get(countLet).peek().charAt(0) != '-')
						{
							list.get(countLet).push(b);
							list.get(countLet).push(":error:");

						}

					}

				}

			} // This is the end of the division function.....

			else if (a.equals("rem"))
			{

				if (list.get(countLet).size() == 1
						|| list.get(countLet).size() == 0)
				{
					list.get(countLet).push(":error:");
				}

				else if (Character
						.isLetter(list.get(countLet).peek().charAt(0))
						&& list2.get(countMap).containsKey(
								list.get(countLet).peek()))
				{
					String m = list.get(countLet).peek();
					String m1 = list2.get(countMap).get(
							list.get(countLet).peek());
					System.out.println("The first number being peeked out is: "
							+ m1);
					// This is the first test case here.
					if (m1.equals("0"))
					{

						list.get(countLet).push(":error:");
						System.out
								.println("Now that an error literal is being pushed onto the stack");

					}
					else if (!m1.equals("0"))
					{

						if (!m1.matches("[0-9]+") && m1.charAt(0) != '-')
						{
							list.get(countLet).push(":error:");

						}
						else if (m1.matches("[0-9]+") || m1.charAt(0) == '-')
						{
							list.get(countLet).pop();
							// }

							if (Character.isLetter(list.get(countLet).peek()
									.charAt(0))
									&& list2.get(countMap).containsKey(
											list.get(countLet).peek()))
							{
								String n = list.get(countLet).peek();
								String n1 = list2.get(countMap).get(
										list.get(countLet).peek());
								if (n1.matches("[0-9]+") || n1.charAt(0) == '-')
								{
									System.out
											.println("Now that the second name is a number");
									System.out
											.println("The second number being popped out is: "
													+ list2.get(countMap).get(
															list.get(countLet)
																	.peek()));
									list.get(countLet).pop();

									String q = Integer.toString(Integer
											.parseInt(n1)
											% Integer.parseInt(m1));
									System.out
											.println("The result of the division is:   "
													+ q);
									list.get(countLet).push(q);
								}
								else if (!n1.matches("[0-9]+")
										&& n1.charAt(0) != '-')
								{
									list.get(countLet).push(m);
									System.out
											.println("Now that the second name is not a number ");
									list.get(countLet).push(":error:");

								}

							}
							else if (list.get(countLet).peek()
									.matches("[0-9]+")
									|| list.get(countLet).peek().charAt(0) == '-')
							{

								String w = Integer.toString(Integer
										.parseInt(list.get(countLet).peek())
										% Integer.parseInt(m));
								list.get(countLet).pop();
								System.out
										.println("The result of the subtraction is: "
												+ w);
								list.get(countLet).push(w);

							}
						}

					}
				}
				else if (!list.get(countLet).peek().matches("[0-9]+")
						&& list.get(countLet).peek().charAt(0) != '-')
				{
					list.get(countLet).push(":error:");
					System.out.println("The top element is not a number");

				}

				else if ((list.get(countLet).peek().matches("[0-9]+") || list
						.get(countLet).peek().charAt(0) == '-'))
				{
					String b = list.get(countLet).pop();
					System.out.println("After popping we have: " + b);
					if (b.equals("0"))
					{
						list.get(countLet).push(b);
						list.get(countLet).push(":error:");
					}
					else if (!b.equals("0"))
					{
						if (Character.isLetter(list.get(countLet).peek()
								.charAt(0))
								&& list2.get(countMap).containsKey(
										list.get(countLet).peek()))
						// This method checks if the map contains the
						// name.........
						{
							String c = list2.get(countMap).get(
									list.get(countLet).peek());
							// This is the
							System.out.println("The second number is: "
									+ list2.get(countMap).get(
											list.get(countLet).peek()));
							list.get(countLet).pop();
							String q = Integer.toString(Integer.parseInt(c)
									% Integer.parseInt(b));
							System.out.println("The addition result is: " + q);
							list.get(countLet).push(q);

						}

						else if (list.get(countLet).peek().matches("[0-9]+")
								|| list.get(countLet).peek().charAt(0) == '-')
						{

							String c = list.get(countLet).pop();
							String d = Integer.toString(Integer.parseInt(c)
									% Integer.parseInt(b));
							list.get(countLet).push(d);

						}
						else if (!list.get(countLet).peek().matches("[0-9]+")
								&& list.get(countLet).peek().charAt(0) != '-')
						{
							list.get(countLet).push(b);
							list.get(countLet).push(":error:");

						}

					}

				}

			} // This i the end of the remainder function......,..........

			else if (a.equals("neg"))
			{

				if (list.get(countLet).size() == 0)
				{
					list.get(countLet).push(":error:");
				}

				else if (list.get(countLet).peek().equals("0"))
				{
					list.get(countLet).push("0");

				}
				else if (Character
						.isLetter(list.get(countLet).peek().charAt(0))
						&& list2.get(countMap).containsKey(
								list.get(countLet).peek()))
				{
					String m = list.get(countLet).peek();
					String m1 = list2.get(countMap).get(m);
					if (!m1.matches("[0-9]+") && m1.charAt(0) != '-')
					{
						list.get(countLet).push(":error:");
					}
					else if (m1.matches("[0-9]+") || m1.charAt(0) == '-')
					{
						list.get(countLet).pop();
						list.get(countLet).push(
								Integer.toString(0 - Integer.parseInt(m1)));
					}
				}
				else if (list.get(countLet).peek().matches("[0-9]+")
						|| list.get(countLet).peek().charAt(0) == '-')
				{
					String b = list.get(countLet).pop();

					list.get(countLet).push(
							Integer.toString(0 - Integer.parseInt(b)));
					System.out
							.println("After implementing the negation method we have: "
									+ Integer.toString(0 - Integer.parseInt(b)));

				}
				else if (!list.get(countLet).peek().matches("[0-9]+")
						&& list.get(countLet).peek().charAt(0) != '-')
				{
					list.get(countLet).push(":error:");

				}

			}

			else if (a.equals("swap"))
			{

				if (list.get(countLet).size() == 1)
				{
					list.get(countLet).push(":error:");
				}
				else if (list.get(countLet).size() == 0)
				{
					list.get(countLet).push(":error:");
				}
				else
				{
					String e = list.get(countLet).pop();
					String f = list.get(countLet).pop();
					list.get(countLet).push(e);
					list.get(countLet).push(f);

				}

			}

			else if (a.equals("pop"))
			{
				if (list.get(countLet).size() == 0)
				{
					list.get(countLet).push(":error:");

				}
				else
				{

					list.get(countLet).pop();

				}
			}

			// I am officially done with my and functions.
			else if (a.equals("and"))
			{

				if (list.get(countLet).size() == 1)
				{

					list.get(countLet).push(":error:");
				}
				else if (list.get(countLet).size() == 0)
				{
					list.get(countLet).push(":error:");

				}
				else if (Character
						.isLetter(list.get(countLet).peek().charAt(0))
						&& list2.get(countMap).containsKey(
								list.get(countLet).peek()))
				{
					String m = list.get(countLet).peek();
					String m1 = list2.get(countMap).get(
							list.get(countLet).peek());
					if (!m1.equals(":true:") && !m1.equals(":false:"))
					{
						list.get(countLet).push(":error:");
					}
					else if (m1.equals(":true:") || m1.equals(":false:"))
					{

						System.out.println("The first boolean is : "
								+ list2.get(countMap).get(
										list.get(countLet).peek()));
						list.get(countLet).pop();
						if (Character.isLetter(list.get(countLet).peek()
								.charAt(0))
								&& list2.get(countMap).containsKey(
										list.get(countLet).peek()))
						{
							String n = list.get(countLet).peek();
							String n1 = list2.get(countMap).get(
									list.get(countLet).peek());
							if (!n1.equals(":true:") && !n1.equals(":false:"))
							{
								list.get(countLet).push(m);
								list.get(countLet).push(":error:");
							}
							else if (n1.equals(":true:")
									|| n1.equals(":false:"))
							{
								System.out.println("The second boolean is: "
										+ list2.get(countMap).get(
												list.get(countLet).peek()));
								list.get(countLet).pop();
								if (m1.equals(":false:")
										&& n1.equals(":false:"))
									list.get(countLet).push(":false:");
								else if (m1.equals(":false:")
										&& n1.equals(":true:"))
									list.get(countLet).push(":false:");
								else if (m1.equals(":true:")
										&& n1.equals(":false:"))
									list.get(countLet).push(":false:");
								else if (m1.equals(":true:")
										&& n1.equals(":true:"))
									list.get(countLet).push(":true:");

							}

						}

					}

				}
				else if (!list.get(countLet).peek().equals(":true:")
						&& !list.get(countLet).peek().equals(":false:"))
				{
					System.out.println("The topp element is not a boolean");
					list.get(countLet).push(":error:");

				}

				else if (list.get(countLet).peek().equals(":true:")
						|| list.get(countLet).peek().equals(":false:"))
				{
					String b = list.get(countLet).pop();
					System.out.println("The first element is being popped out");
					// This block of code determines if the second element is
					// boolean or not.
					if (!list.get(countLet).peek().equals(":true:")
							&& !list.get(countLet).peek().equals(":false:"))
					{
						list.get(countLet).push(b);
						System.out
								.println("The second element of the stack is not a boolean value");
						list.get(countLet).push(":error:");
					}

					if (list.get(countLet).peek().equals(":true:")
							|| list.get(countLet).peek().equals(":false:"))
					{
						String c = list.get(countLet).pop();
						System.out
								.println("The second element is being popped out");
						if (c.equals(":true:") && b.equals(":true:"))
							list.get(countLet).push(":true:");

						if (c.equals(":true:") && b.equals(":false:"))
							list.get(countLet).push(":false:");

						if (c.equals(":false:") && b.equals(":true:"))
							list.get(countLet).push(":false:");

						if (c.equals(":false:") && b.equals(":false:"))
							list.get(countLet).push(":false:");

					} // This is the end of the second if statements.

				} // And this is the end of the first if statement.
			}

			// I am officially done with the or function.

			else if (a.equals("or"))
			{
				if (list.get(countLet).size() == 1)
				{

					list.get(countLet).push(":error:");
				}
				else if (list.get(countLet).size() == 0)
				{
					list.get(countLet).push(":error:");

				}
				else if (Character
						.isLetter(list.get(countLet).peek().charAt(0))
						&& list2.get(countMap).containsKey(
								list.get(countLet).peek()))
				{
					String m = list.get(countLet).peek();
					String m1 = list2.get(countMap).get(
							list.get(countLet).peek());
					if (!list2.get(countMap).get(list.get(countLet).peek())
							.equals(":true:")
							&& !list2.get(countMap)
									.get(list.get(countLet).peek())
									.equals(":false:"))
					{
						list.get(countLet).push(":error:");
					}
					else if (list2.get(countMap).get(list.get(countLet).peek())
							.equals(":true:")
							|| list2.get(countMap)
									.get(list.get(countLet).peek())
									.equals(":false:"))
					{

						System.out.println("The first boolean is : "
								+ list2.get(countMap).get(
										list.get(countLet).peek()));
						list.get(countLet).pop();
						if (Character.isLetter(list.get(countLet).peek()
								.charAt(0))
								&& list2.get(countMap).containsKey(
										list.get(countLet).peek()))
						{
							String n = list.get(countLet).peek();
							String n1 = list2.get(countMap).get(
									list.get(countLet).peek());
							if (!list2.get(countMap)
									.get(list.get(countLet).peek())
									.equals(":true:")
									&& !list2.get(countMap)
											.get(list.get(countLet).peek())
											.equals(":false:"))
							{
								list.get(countLet).push(m);
								list.get(countLet).push(":error:");
							}
							else if (list2.get(countMap)
									.get(list.get(countLet).peek())
									.equals(":true:")
									|| list2.get(countMap)
											.get(list.get(countLet).peek())
											.equals(":false:"))
							{
								System.out.println("The second boolean is: "
										+ list2.get(countMap).get(
												list.get(countLet).peek()));
								list.get(countLet).pop();
								if (m1.equals(":false:")
										&& n1.equals(":false:"))
									list.get(countLet).push(":false:");
								else if (m1.equals(":false:")
										&& n1.equals(":true:"))
									list.get(countLet).push(":true:");
								else if (m1.equals(":true:")
										&& n1.equals(":false:"))
									list.get(countLet).push(":true:");
								else if (m1.equals(":true:")
										&& n1.equals(":true:"))
									list.get(countLet).push(":true:");

							}

						}

					}

				}

				else if (!list.get(countLet).peek().equals(":true:")
						&& !list.get(countLet).peek().equals(":false:"))
				{
					System.out.println("The top element is not a boolean");
					list.get(countLet).push(":error:");

				}

				else if (list.get(countLet).peek().equals(":true:")
						|| list.get(countLet).peek().equals(":false:"))
				{
					String r = list.get(countLet).peek();
					list.get(countLet).pop();
					String b = list.get(countLet).peek();

					if (Character.isLetter(list.get(countLet).peek().charAt(0))
							&& list2.get(countMap).containsKey(
									list.get(countLet).peek()))
					{
						String b1 = list2.get(countMap).get(b);
						list.get(countLet).pop();

						if (!b1.equals(":true:") && !b1.equals(":false:"))
						{
							list.get(countLet).push(b);
							list.get(countLet).push(":error:");

						}
						else if (b1.equals(":true:") || b1.equals(":false:"))
						{
							if (r.equals(":true:") && b1.equals(":true"))
								list.get(countLet).push(":true:");
							else if (r.equals(":true:") && b1.equals(":false:"))
								list.get(countLet).push(":true:");
							else if (r.equals(":false:") && b1.equals(":true:"))
								list.get(countLet).push(":true:");
							else if (r.equals(":false:")
									&& b1.equals(":false:"))
								list.get(countLet).push(":false:");

						}
					}

					// This block of code determines if the second element is
					// boolean or not.
					else if (!list.get(countLet).peek().equals(":true:")
							&& !list.get(countLet).peek().equals(":false:"))
					{
						list.get(countLet).push(b);
						System.out
								.println("The second element of the stack is not a boolean value");
						list.get(countLet).push(":error:");
					}

					else if (list.get(countLet).peek().equals(":true:")
							|| list.get(countLet).peek().equals(":false:"))
					{
						String c = list.get(countLet).pop();
						System.out
								.println("The second element is being popped out");
						if (c.equals(":true:") && b.equals(":true:"))
							list.get(countLet).push(":true:");

						if (c.equals(":true:") && b.equals(":false:"))
							list.get(countLet).push(":true:");

						if (c.equals(":false:") && b.equals(":true:"))
							list.get(countLet).push(":true:");

						if (c.equals(":false:") && b.equals(":false:"))
							list.get(countLet).push(":false:");

					} // This is the end of the second if statements.

				}
			}
			// I am officially done with the not function.
			else if (a.equals("not"))
			{
				if (list.get(countLet).size() == 0)
				{
					list.get(countLet).push(":error:");

				}
				else if (Character
						.isLetter(list.get(countLet).peek().charAt(0))
						&& list2.get(countMap).containsKey(
								list.get(countLet).peek()))
				{
					String m = list.get(countLet).peek();
					String m1 = list2.get(countMap).get(
							list.get(countLet).peek());
					if (!list2.get(countMap).get(list.get(countLet).peek())
							.equals(":true:")
							&& !list2.get(countMap)
									.get(list.get(countLet).peek())
									.equals(":false:"))
					{
						list.get(countLet).push(":error:");
					}
					else if (list2.get(countMap).get(list.get(countLet).peek())
							.equals(":true:")
							|| list2.get(countMap)
									.get(list.get(countLet).peek())
									.equals(":false:"))
					{
						list.get(countLet).pop();
						if (m1.equals(":true:"))
							list.get(countLet).push(":false:");
						else if (m1.equals(":false:"))
							list.get(countLet).push(":true:");

					}

				}

				else if (!list.get(countLet).peek().equals(":true:")
						&& !list.get(countLet).peek().equals(":false:"))
				{
					list.get(countLet).push(":error:");

				}
				else if (list.get(countLet).peek().equals(":true:")
						|| list.get(countLet).peek().equals(":false:"))
				{
					String b = list.get(countLet).pop();
					if (b.equals(":true:"))
						list.get(countLet).push(":false:");
					if (b.equals(":false:"))
						list.get(countLet).push(":true:");

				}
			}
			else if (a.equals("equal"))
			{
				if (list.get(countLet).size() == 1
						|| list.get(countLet).size() == 0)
				{
					list.get(countLet).push(":error:");
				}

				else if (Character
						.isLetter(list.get(countLet).peek().charAt(0))
						&& list2.get(countMap).containsKey(
								list.get(countLet).peek()))
				{

					// This checks if the top element is a name.
					String m = list.get(countLet).peek();
					String m1 = list2.get(countMap).get(
							list.get(countLet).peek());
					if (!list2.get(countMap).get(list.get(countLet).peek())
							.matches("[0-9]+")
							&& list2.get(countMap)
									.get(list.get(countLet).peek()).charAt(0) != '-')
					{
						// This checks if the name is a number.
						list.get(countLet).push(":error:");
					}
					else if (list2.get(countMap).get(list.get(countLet).peek())
							.matches("[0-9]+")
							|| (list2.get(countMap)
									.get(list.get(countLet).peek()).charAt(0) == '-' && Character
									.isDigit(list2.get(countMap)
											.get(list.get(countLet).peek())
											.charAt(1))))
					{
						// if the name is a number, then pop the stack.
						list.get(countLet).pop();
						String n = list.get(countLet).peek();
						String n1 = list2.get(countMap).get(
								list.get(countLet).peek());
						System.out.println("Now that the second number is: "
								+ n1);
						// and then check if the second element from the top is
						// a number or not.
						if (Character.isLetter(list.get(countLet).peek()
								.charAt(0))
								&& list2.get(countMap).containsKey(
										list.get(countLet).peek()))
						{
							// This checks if the second element from the top is
							// a name and a number.
							if (!list2.get(countMap)
									.get(list.get(countLet).peek())
									.matches("[0-9]+")
									&& list2.get(countMap)
											.get(list.get(countLet).peek())
											.charAt(0) != '-')
							{
								list.get(countLet).push(m);
								list.get(countLet).push(":error:");
							}
							else if (list2.get(countMap)
									.get(list.get(countLet).peek())
									.matches("[0-9]+")
									|| (list2.get(countMap)
											.get(list.get(countLet).peek())
											.charAt(0) == '-' && Character
											.isDigit(list2
													.get(countMap)
													.get(list.get(countLet)
															.peek()).charAt(0))))
							{
								list.get(countLet).pop();
								if (m1.equals(n1))
									list.get(countLet).push(":true:");
								else if (!m1.equals(n1))
									list.get(countLet).push(":false:");

							}
						} // The code block ends here which checks if the second
							// element from the top is a name and if it is an
							// integer or not
						else if (!list.get(countLet).peek().matches("[0-9]+")
								&& list.get(countLet).peek().charAt(0) != '-')
						{

							list.get(countLet).push(m);
							list.get(countLet).push(":error:");

						}
						else if (list.get(countLet).peek().matches("[0-9]+")
								|| (list.get(countLet).peek().charAt(0) == '-' && Character
										.isDigit(list.get(countLet).peek()
												.charAt(1))))
						{
							System.out
									.println("After first element from the top is: "
											+ m1);
							System.out
									.println("second element from the top is: "
											+ n);

							list.get(countLet).pop();
							if (m1.equals(n))
								list.get(countLet).push(":true:");
							else if (!m1.equals(n))
								list.get(countLet).push(":false:");
						}

					}

				}

				else if (!list.get(countLet).peek().matches("[0-9]+")
						&& list.get(countLet).peek().charAt(0) != '-')
				{
					list.get(countLet).push(":error:");

				}
				else if (list.get(countLet).peek().matches("[0-9]+")
						|| list.get(countLet).peek().charAt(0) == '-')
				{

					String b = list.get(countLet).peek();
					list.get(countLet).pop();

					if (Character.isLetter(list.get(countLet).peek().charAt(0))
							&& list2.get(countMap).containsKey(
									list.get(countLet).peek()))
					{
						String m = list.get(countLet).peek();
						String m1 = list2.get(countMap).get(
								list.get(countLet).peek());
						if (m1.matches("[0-9]+")
								|| (m1.charAt(0) == '-' && Character.isDigit(m1
										.charAt(1))))
						{
							list.get(countLet).pop();

							if (b.equals(m1))
								list.get(countLet).push(":true:");
							else if (!b.equals(m1))
								list.get(countLet).push(":false:");
						}
						else if (!m1.matches("[0-9]+") && m1.charAt(0) != '-')
						{
							list.get(countLet).push(b);
							list.get(countLet).push(":error:");

						}

					}
					else if (list.get(countLet).peek().matches("[0-9]+")
							|| list.get(countLet).peek().charAt(0) == '-')
					{
						String c = list.get(countLet).pop();
						if (b.equals(c))
							list.get(countLet).push(":true:");

						else if (!b.equals(c))
							list.get(countLet).push(":false:");

					}
					else if (!list.get(countLet).peek().matches("[0-9]+")
							|| list.get(countLet).peek().charAt(0) != '-')
					{
						list.get(countLet).push(b);
						list.get(countLet).push(":error:");

					}

				}

			}
			else if (a.equals("lessThan"))
			{
				if (list.get(countLet).size() == 1)
				{
					list.get(countLet).push(":error:");
				}
				else if (list.get(countLet).size() == 0)
				{
					list.get(countLet).push(":error:");

				}
				else if (Character
						.isLetter(list.get(countLet).peek().charAt(0))
						&& list2.get(countMap).containsKey(
								list.get(countLet).peek()))
				{
					// Make sure that m equals list.get(countLet).peek();
					String m = list.get(countLet).peek();
					String m1 = list2.get(countMap).get(
							list.get(countLet).peek());
					if (!list2.get(countMap).get(list.get(countLet).peek())
							.matches("[0-9]+")
							&& list2.get(countMap)
									.get(list.get(countLet).peek()).charAt(0) != '-')
					{
						list.get(countLet).push(":error:");
					}
					else if (list2.get(countMap).get(list.get(countLet).peek())
							.matches("[0-9]+")
							|| list2.get(countMap)
									.get(list.get(countLet).peek()).charAt(0) == '-')
					{
						list.get(countLet).pop();
						String n = list.get(countLet).peek();
						String n1 = list2.get(countMap).get(
								list.get(countLet).peek());
						if (!list2.get(countMap).get(list.get(countLet).peek())
								.matches("[0-9]+")
								&& list2.get(countMap)
										.get(list.get(countLet).peek())
										.charAt(0) != '-')
						{
							list.get(countLet).push(m);
							list.get(countLet).push(":error:");

						}
						else if (list2.get(countMap)
								.get(list.get(countLet).peek())
								.matches("[0-9]+")
								|| list2.get(countMap)
										.get(list.get(countLet).peek())
										.charAt(0) == '-')
						{
							list.get(countLet).pop();
							if (Integer.parseInt(n1) < Integer.parseInt(m1))
								list.get(countLet).push(":true:");
							else if (Integer.parseInt(n1) >= Integer
									.parseInt(m1))
								list.get(countLet).push(":false:");
						}

					}

				}

				else if (!list.get(countLet).peek().matches("[0-9]+")
						&& list.get(countLet).peek().charAt(0) != '-')
				{
					list.get(countLet).push(":error:");

				}
				if (list.get(countLet).peek().matches("[0-9]+")
						|| list.get(countLet).peek().charAt(0) == '-')
				{
					String b = list.get(countLet).pop();
					System.out.println("Now that we have a number and it is: "
							+ Integer.parseInt(b));

					if (!list.get(countLet).peek().matches("[0-9]+")
							&& list.get(countLet).peek().charAt(0) != '-')
					{
						list.get(countLet).push(b);

						list.get(countLet).push(":error:");

					}
					else if (list.get(countLet).peek().matches("[0-9]+")
							|| list.get(countLet).peek().charAt(0) == '-')
					{
						String c = list.get(countLet).pop();
						System.out.println("Now that we have another number "
								+ Integer.parseInt(c));
						if (Integer.parseInt(b) > Integer.parseInt(c))

							list.get(countLet).push(":true:");

						if (Integer.parseInt(b) <= Integer.parseInt(c))

							list.get(countLet).push(":false:");

					}

				}

			}
			else if (a.equals("if"))
			{
				if (list.get(countLet).size() == 0
						|| list.get(countLet).size() < 3)
				{

					list.get(countLet).push(":error:");
				}

				else if (list.get(countLet).size() != 0
						&& list.get(countLet).size() >= 3)
				{

					String b = list.get(countLet).pop();// x

					String c = list.get(countLet).pop();// y
					String d = list.get(countLet).pop();// z
					if (Character.isLetter(d.charAt(0))
							&& list2.get(countMap).containsKey(d))
					{
						String d1 = list2.get(countMap).get(d);
						if (!d1.equals(":true:") && !d1.equals(":false:"))
						{
							list.get(countLet).push(d);
							list.get(countLet).push(c);
							list.get(countLet).push(b);
							list.get(countLet).push(":error:");
						}
						else if (d1.equals(":true:"))
						{
							list.get(countLet).push(b);
						}
						else if (d1.equals(":false:"))
						{
							list.get(countLet).push(c);
						}

					}

					else if (!d.equals(":true:") && !d.equals(":false:"))
					{
						list.get(countLet).push(d);
						list.get(countLet).push(c);
						list.get(countLet).push(b);
						list.get(countLet).push(":error:");
					}
					else if (d.equals(":true:"))
					{
						list.get(countLet).push(b);
					}
					else if (d.equals(":false:"))
					{
						list.get(countLet).push(c);
					}

				}

			}
			else if (a.equals("bind"))
			{
				if (list.get(countLet).size() == 0
						|| list.get(countLet).size() == 1)
				{
					list.get(countLet).push(":error:");
				}
				else if (list.get(countLet).size() > 1)
				{
					String b = list.get(countLet).pop();
					String c = list.get(countLet).pop();

					if (Character.isLetter(c.charAt(0)))
					{
						if (Character.isLetter(b.charAt(0))
								&& list2.get(countMap).containsKey(b))
						{
							String b1 = list2.get(countMap).get(b);
							if (b1.matches("[0-9]+") || b1.charAt(0) == '-'
									|| b1.charAt(0) == '"'
									|| b1.equals(":true:")
									|| b1.equals(":false:")
									|| b1.equals(":unit:"))
							{
								list.get(countLet).push(":unit:");
								list2.get(countMap).put(c, b1);
							}
							else if (!b1.matches("[0-9]+")
									&& b1.charAt(0) != '-'
									&& b1.charAt(0) != '"'
									&& !b1.equals(":true:")
									&& !b1.equals(":false:")
									&& !b1.equals(":unit:"))
							{
								list.get(countLet).push(c);
								list.get(countLet).push(b);
								list.get(countLet).push(":error:");
							}
						}
						else if (b.matches("[0-9]+") || b.charAt(0) == '-'
								|| b.charAt(0) == '"' || b.equals(":true:")
								|| b.equals(":false:") || b.equals(":unit:"))
						{
							list.get(countLet).push(":unit:");
							list2.get(countMap).put(c, b);
						}
						else
						{
							list.get(countLet).push(c);
							list.get(countLet).push(b);
							list.get(countLet).push(":error:");

						}

					}
					else if (!Character.isLetter(c.charAt(0)))
					{
						list.get(countLet).push(c);
						list.get(countLet).push(b);
						list.get(countLet).push(":error:");

					}
				}
			}

			// I need a lot of work on this let end function.
			else if (a.equals("let"))

			{

				if (countMapString < 1)
				{
					countMapString++;
					mapString2 = new HashMap<String, ArrayList<String>>(
							mapStringList.get(0));
					mapStringList.add(mapString2);

				}
				if (countMap < 1)
				{

					countMap++;
					// list2.get(countMap).putAll(list2.get(countMap-1));
					map2 = new HashMap<String, String>(list2.get(0));

					list2.add(map2);
					System.out.println("Now that the size of list2 is: "
							+ list2.size());
					System.out.println("There are: "
							+ list2.get(countMap - 1).size()
							+ " elements in map1");

					System.out.println("After we hit the first LET map"
							+ (countMap - 1) + " items are being moved to map"
							+ (countMap));
					System.out
							.println("The number of map has been increased from 0 to: "
									+ countMap);

				}
				countLet++;
				countLet1++;
				System.out
						.println("Now that we created another stack inside this list");
				Stack<String> stack1 = new Stack<String>();

				list.add(stack1);

			}

			else if (a.equals("end") && list.size() > 2)
			{
				countEnd++;

				list.get(countLet - 1).push(list.get(countLet).peek());

				list.remove(list.get(countLet));

				countLet--;

				countEnd--;
			} // This is the end of the second
				// enddddddddddddddddddddddddddddddddddddd...............

			else if (a.equals("end") && list.size() == 2)
			{
				countEnd++;

				System.out.println("There are: " + list2.get(countMap).size()
						+ " elements in map2");

				if (countEnd == countLet)
				{
					System.out
							.println("countEnd and countLet is equal in terms of numbers. ");
					System.out.println("There are: " + list.size()
							+ " stacks inside this list");

					System.out
							.println(list.get(countLet).peek()
									+ "Now that the second unit is being pushed onto the main stack ");
					list.get(countLet - 1).push(list.get(countLet).peek());
					list.remove(list.get(countLet));
					// list2.get(countMap-1).putAll(list2.get(countMap));
					System.out
							.println("after we hit the first end the elements of map"
									+ countMap
									+ " are being moved to map"
									+ (countMap - 1));
					list2.remove(list2.get(countMap));
					mapStringList.remove(mapStringList.get(countMapString));

					System.out
							.println("Now that the index of the map inside the list is:  "
									+ countMap);
					countLet1 = 0;
					countEnd = 0;
					countLet = 0;
					countMap = 0;
					countMapString = 0;

					// This is basically the same as countMap--;

				}
			} // This marks the end of the first end

			else if (a.equals("fun") || a.equals("inOutFun"))
			{

				String functionName = list4.get(i + 1);
				String b = list4.get(i + 1);
				i++;
				ArrayList<String> listQ = new ArrayList<String>();
				listQ.add(a);
				while (!b.equals("funEnd"))
				{
					listQ.add(b);
					b = list4.get(i + 1);
					i++;
					if (b.equals("funEnd"))
					{

						list.get(countLet).push(":unit:");

						break;

					}
				}

				System.out.println("The command list is: " + listQ);
				for (int q = 0; q < listQ.size(); q++)
				{
					if (list2.get(countMap).containsKey(listQ.get(q)))
					{
						String f = listQ.get(q);
						System.out.println("The key is: " + listQ.get(q));
						listQ.remove(listQ.get(q));
						System.out.println("The value of the key is: "
								+ list2.get(countMap).get(f));
						listQ.add(q, list2.get(countMap).get(f));

					}
				}

				System.out.println("The updated command list is: " + listQ);
				listQ.remove(listQ.get(1));
				listQ.remove(listQ.get(listQ.size() - 1));
				// listQ.remove(listQ.get(listQ.size()-1));

				System.out.println("The second updated command list is: "
						+ listQ);
				mapStringList.get(countMapString).put(functionName, listQ);

			}

			else if (a.equals("call"))
			{
				ArrayList<String> L = mapStringList.get(countMapString).get(
						list.get(countLet).peek());

				if (L.get(0).equals("fun"))
				{
					System.out
							.println("Now that the first string of the list L is fun ");
					if (mapStringList.size() > 1)
					{
						if (mapStringList.get(countMapString).containsKey(
								list.get(countLet).peek())
								&& !mapStringList.get(countMapString - 1)
										.containsKey(list.get(countLet).peek()))
						{
							list.get(countLet).push(":error:");

						}

					}

					System.out.println("mapString.get(b) is: "
							+ mapStringList.get(countMapString).get(
									list.get(countLet).peek()));
					if (mapStringList.get(countMapString).containsKey(
							list.get(countLet).peek()))
					{
						String d = list.get(countLet).peek();
						System.out.println("String D is: " + d);
						// ArrayList<String> L =
						// mapStringList.get(countMapString).get(list.get(countLet).peek());

						System.out.println("L is: " + L);

						String c = L.get(1);

						list.get(countLet).pop();
						System.out
								.println("After popping out the first element the top elelemtnis: "
										+ list.get(countLet).peek());

						for (int p = 0; p < L.size(); p++)
						{
							if (L.get(p).equals(c))
							{

								// list2.get(countMap).put(L.get(p),
								// list4.get(i-3));
								L.remove(L.get(p));
								if (list2.get(countMap).containsKey(
										list4.get(i - 3)))
								{
									System.out
											.println("The key element is contained here ");
									L.add(p,
											list2.get(countMap).get(
													list4.get(i - 3)));

								}
								else
								{
									L.add(p, list4.get(i - 3));

								}

							}
						}

						System.out
								.println("List L before removing any element is: "
										+ L);
						L.remove(0);
						L.remove(0);

						if (!list.get(countLet).peek().equals(":error:"))
						{
							list.get(countLet).pop();
						}
						else if (list.get(countLet).peek().equals(":error:"))
						{
							list.get(countLet).push(d);

						}

						list4.clear();

						for (int w = 0; w < L.size(); w++)
						{
							list4.add(L.get(w));

						}
						System.out
								.println("The completely brand new list4 is: "
										+ list4);
						i = -1;

					}

				}

			}

		}

		try
		{
			PrintWriter outputstream = new PrintWriter(output);

			while (list.get(0).size() > 0)
			{

				if (list.get(0).peek().charAt(0) == '"')
				{

					outputstream.println(list.get(0).peek()
							.substring(1, list.get(0).peek().length() - 1));

					list.get(0).pop();

				}
				else
				{

					outputstream.println(list.get(0).peek());
					list.get(0).pop();

				}

			}

			outputstream.close();

		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		x.close();

		// This curly brace is related to the top while loop that deals with
		// reading the file and all other functions has nothing to do with this
		// function.

	}

	public static void main(String[] args)
	{
		interpreter in = new interpreter();
		try
		{
			in.interpreter("input.txt", "output.txt");
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HashMap<String, String> x = new HashMap<>();
		x.put("1", "Jerry");
		x.put("2", "tom");
		System.out.println(x.get("1"));

	}
}
