import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class automatron
	{

		public static long toAscii(String s)
			{
				StringBuilder sb = new StringBuilder();
				long asciiInt;
				for (int i = 0; i < s.length(); i++)
					{
						char c = s.charAt(i);
						asciiInt = (int)c; 
						sb.append(asciiInt);
					}
				return Long.parseLong(sb.toString());
			}

		public static void main(String[] args) throws IOException
			{
				BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
				
				int len, i, j, bDMG = 0, fDMG = 0, tDMG = 0;;
				String x, q0 = "1", qn[] = {"1", "2", "3"}, latest, f = "3", sigma[] = {"0", "1"};
				latest = q0;
				
				System.out.print("Enter sigma: ");
				x = dataIn.readLine();
				len = x.length();
				String to_ascii[] = x.split("");
				for (i = 0; i < len; i++)
					{
						long ascii = toAscii(to_ascii[i]);
						String y = Long.toBinaryString(ascii);
						int lentwo = y.length();
						String bin[] = y.split("");
						for (j = 0; j < lentwo; j++)
							{
								if (bin[j].equals("0") || bin[j].equals("1") )
									{
										if (latest.equals(q0) && bin[j].equals(sigma[0]))
											{
												latest = qn[0];
											}
										else if (latest.equals(q0) && bin[j].equals(sigma[1]))
											{
												latest = qn[1];
											}
										else if (latest.equals(qn[1]) && bin[j].equals(sigma[1]))
											{
												latest = qn[1];
											}
										else if (latest.equals(qn[1]) && bin[j].equals(sigma[0]))
											{
												latest = qn[2];
												bDMG += 1;
											}
										else if (latest.equals(qn[2]) && bin[j].equals(sigma[0]) || bin[j].equals(sigma[1]))
											{
												latest = qn[2];
												bDMG += 1;
											}
									}
								else
									{
										throw new IllegalArgumentException("OOPS, YOU'VE ENCOUNTERED A BUG.\nCONTACT DEVELOPER IMMEDIATELY!");
									}
							}
					}
				tDMG = len * bDMG;
				fDMG = tDMG * 1111;
				System.out.print(latest == f ? "\nNice! Dealt " + fDMG + " DMG!" : "\nBad shot. Minus " + fDMG + " HP.");
				System.exit(0);
			}
	}