    package com.java;

    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
// TODO ==========================================================\\


// TODO _________________ Y. The last 2 digitsY. The last 2 digits  _____________
// TODO _________________________________________________________________________


            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            int n4 = sc.nextInt();
            System.out.println((n1*n2*n3*n4)%100);


// TODO _________________ W. Shape3  _______________________________________________
// TODO _________________________________________________________________________



            int inp = sc.nextInt();

            int ast = 1;
            int spa = inp - 1;

            for(int i = 0; i < inp; i++){

                for(int j = 0 ;j <= spa ;j++){
                    System.out.print(" ");
                }
                for(int j = 1 ;j <= ast ;j++){
                    System.out.print("*");
                }
                System.out.println();
                ast+=2;
                spa--;
            }

            ast -= 2;
            spa++;


            for(int i = 0; i < inp; i++){

                for(int j = 0 ;j <= spa ;j++){
                    System.out.print(" ");
                }

                for(int j = 1 ;j <= ast ;j++){
                    System.out.print("*");
                }
                System.out.println();
                ast-=2;
                spa++;
            }


// TODO _________________ W. Mirror Array  _______________________________
//// TODO ________________________________________________________________



            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] arr = new int[n][m];

            for(int i = 0 ; i < n ; i++){

                for(int j = 0 ; j < m ; j++){

                    arr[i][j] = sc.nextInt();
                }
            }


            for(int i = 0 ; i < n ; i++)
            {
                for(int j = m-1 ; j >=0 ; j--)
                {
                    System.out.print( arr[i][j]);
                    if(j>=1)
                    {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }


// TODO _________________ T. URL  ____________________________________________
// TODO _____________________________________________________________________


            String url = sc.next();

            int start = 0;
            int len = 1;

            for(int i = 0 ; i < url.length() ; i++)
            {
                if(url.charAt(i) == '?')
                {
                    start = i;
                }
            }

            for(int i = 0 ; i < url.length() ; i++)
            {
                if(url.charAt(i) == '&')
                {
                    len ++;
                }
            }

            int end =start+1;

            len += end;


            for(int i = end ; i < len ; i++){


                for(int j = end ; j < url.length() ; j++){
                    if(url.charAt(j) == '=')
                    {
                        break;
                    }
                    System.out.print(url.charAt(j));
                    end = j;

                }
                System.out.print(": ");

                end+=2;

                for(int j = end; j < url.length() ; j++){
                    if(url.charAt(j) == '&')
                    {
                        break;
                    }
                    System.out.print(url.charAt(j));
                    end = j;
                }
                end+=2;
                System.out.println();
            }



// TODO _________________ I. Count Vowels  ____________________________________________
// TODO ______________________________________________________________________________


            String str = sc.nextLine();

            int vowels = 0;
            for(int i = 0 ; i < str.length() ; i++)
            {
                if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                    || str.charAt(i) == 'o' || str.charAt(i) == 'u')
                { vowels++; }
            }
            System.out.println(vowels);



// TODO _________________ E. Assiut Summer Camp  _______________________________
// TODO _________________________________________________________________________



            long n = sc.nextLong();
            long[] nums = new long[(int) n];


            String[] names = new String[4];
            names [0] = "Hussien";
            names [1] = "Atef";
            names [2] = "Karemo";
            names [3] = "Ezzat";



            for ( int x = 0 ; x < n ; x++) {

                int res1 = 0;
                int res2 = 0;

                for (int i = 0; i < 4; i++)
                {
                    nums[i] = sc.nextInt();
                }

                long n1 = nums[0]; // 10


                for (int j = 0; j < 4; j++) // 0 1 2 3
                {
                    if (nums[j] > n1)
                    {
                        n1 = nums[j]; // 4
                        res1 = j; // 3

                    }
                    // n1 = 55  3  K

                }
                nums[res1] = -1;

                long n2 = nums[0]; // 10
                for (int im = 0; im < 4; im++) // 0 1
                {
                    if (nums[im] > n2)
                    {
                        n2 = nums[im];
                        res2 = im;
                    }
                }
                System.out.println(names[res1] + " " + names[res2]);

            }

// TODO _________________ F. update range  ______________________________________
// TODO _________________________________________________________________________



            int size = sc.nextInt();
            int query = sc.nextInt();
            int[] arr = new int[size+1];

            for(int i = 1; i < size+1; i++)
            {
                arr[i] = sc.nextInt();
            }


            for (int i = 1; i <= query; i++)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                int n3 = sc.nextInt();

                for (int j = n1 ;j <= n2 ; j++)
                {
                    arr[j] += n3;
                }
            }

            for (int i = 1; i < size+1; i++)
            {
                System.out.print(arr[i]);
                if(i != size)
                System.out.print(" ");
            }

// TODO _________________ F. Debts ____________________________________________
// TODO _________________________________________________________________________



            int trainees = sc.nextInt();

            long[] arr = new long[trainees+1];

            int helps = sc.nextInt();

            for(int i = 1 ; i <= trainees ; i++)
            {
                arr[i] = sc.nextInt();
            }

            for (int i = 1; i <= helps; i++)
            {

                long n1 = sc.nextLong();
                long n2 = sc.nextLong();
                long coins = sc.nextLong();

                arr[(int)n1] -= coins;
                arr[(int)n2] += coins;
            }

            boolean check = true;
            for (int i = 1; i <= trainees; i++)
            {
                if(arr[i] < 0)
                {
                    check = false;
                }
            }

            if(check)
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }



 // TODO ____________________________Finish ________________________________
// TODO ____________________________________________________________________


        }
    }
