import java.util.Comparator;
import java.util.Iterator;
public class YuvalsTesterAss5 {
    public static void main(String[] args) {
        System.out.println("intro:");
        System.out.println("hey, this is yuval zilber, i wrote this tester for 1 reason, to help you");
        System.out.println("if you have any question about this assignment - contact me.");
        System.out.println("if you need help in anything, logic, calculus, algebra, infi, bdida - contact me");
        System.out.println("i'm available in whatsapp - 0504840490");
        Bank bank=new Bank();
        System.out.println("-----balance() and toString()-----");
        for (int i = 0; i < 100; i++){
            String str = (numToStr(i));
            int accnum=(((i+1)*940817)%1019);
            int bal=(((i+1)*941513)%3307);
            BankAccount ba10=new BankAccount(str,accnum,bal);
            bank.add(ba10);
            bank.balance();
            if(i==7|i==6|i==5)
            {
                int g=0;
            }
            if(getHeight(((BankAccountBinarySearchTree)bank.exportAccountNumbers()).root)!=goodHeight(i+1)|getHeight(((BankAccountBinarySearchTree)bank.exportNames()).root)!=goodHeight(i+1))
                System.out.println("bad balance: "+(i+1)+" items");
            //System.out.println(bank.exportNames().toString());
        }
        int added=((BankAccountBinarySearchTree)bank.exportAccountNumbers()).size();
        boolean flag=(added==100);
        if(!flag)
            System.out.println("you din't added them all, you added only "+added+" of them");
        System.out.print("test 1 - ");
        bank.balance();
        int afterbalance=((BankAccountBinarySearchTree)bank.exportAccountNumbers()).size();

        if(afterbalance==100)
            System.out.println("PASS");
        else{
            System.out.println("fail");
            if (flag)
                System.out.println("you lost some nodes in balance() method.\nyou had 100 bank accounts in the tree before the balance.\nyou have only " + afterbalance);
            else{
                System.out.println("at least added them all");}
            return;
        }
        System.out.print("test 2 - ");
        String yuvalsAns1="tree:((((((280,(427)),574,(721,(560))),707,((854,(1001)),840,(987,(115)))),262,(((101,(248)),395,(542,(381))),528,((675,(822)),661,((808),955,(83))))),941,((((69,(216)),363,(202,(349))),496,((643,(482)),629,(776,(923)))),762,(((909,(37)),184,(23,(170))),317,((464,(303)),450,((597),744,(583)))))),730,(((((877,(5)),863,(1010,(138))),285,((124,(271)),418,(565,(404)))),551,(((698,(845)),684,(831,(978))),106,((964,(92)),239,((386),225,(372))))),519,((((666,(505)),652,(799,(946))),785,((932,(60)),207,((46),193,(340)))),487,(((326,(473)),620,(606,(753))),900,((886,(14)),161,((147),294,(441)))))))";
        BinarySearchTree<Integer> yuvalsTree1=str2tree(yuvalsAns1);
        BinarySearchTree<BankAccount> yourTree1=(BinarySearchTree<BankAccount>)bank.exportNames();
        BinarySearchTree<Integer> yourIntegerTree1=null;
        try{
            yourIntegerTree1 = getIntegerTree(yourTree1);
        }catch (Exception e){
            System.out.println("your toString() is not good, fix it first, can't continue to check");
            return;
        }
        if((!bank.exportNames().toString().equals(yuvalsAns1))&isTreesEquals(yuvalsTree1.root,yourIntegerTree1.root))
            System.out.println("####ERROR: 122#### contact me now!/n0504840490");
        String toAdd="";
        if(isTreesEquals2Level(yourIntegerTree1,yuvalsTree1)){
            System.out.print("PASS");
            toAdd=" - not excectly as mine.(supposed to pass their automatic tests)";
            if(isTreesEquals(yuvalsTree1.root,yourIntegerTree1.root))
                toAdd=" - excectly as mine";
            System.out.println(toAdd);
        }
        else{
            System.out.println("fail");
            if(yuvalsAns1.replaceAll("\\)","").replaceAll(",","").equals(bank.exportNames().toString().replaceAll("\\)","").replaceAll(",","")))
                System.out.println("your balance is good! your toString() failed..");
            if(!isBalancedbyHeight(( (BankAccountBinarySearchTree)bank.exportAccountNumbers() ).root)){
                System.out.println("your tree is not ba1lanced.");
                int height=( (BankAccountBinarySearchTree)bank.exportAccountNumbers() ).height();
                if(height!=6){
                    System.out.println("the target tree height: 6");
                    System.out.println("your tree height: " +height);
                }
            }
            else
                System.out.println("your tree is balanced. probably it the 'toString()'");
        }
        System.out.print("test 3 - ");
        String yuvalsAns2="tree:((((((5,(14)),23,(37,(46))),60,((69,(83)),92,(101,(106)))),115,(((124,(138)),147,(161,(170))),184,((193,(202)),207,((216),225,(239))))),248,((((262,(271)),280,(285,(294))),303,((317,(326)),340,(349,(363)))),372,(((381,(386)),395,(404,(418))),427,((441,(450)),464,((473),482,(487)))))),496,(((((505,(519)),528,(542,(551))),560,((565,(574)),583,(597,(606)))),620,(((629,(643)),652,(661,(666))),675,((684,(698)),707,((721),730,(744))))),753,((((762,(776)),785,(799,(808))),822,((831,(840)),845,((854),863,(877)))),886,(((900,(909)),923,(932,(941))),946,((955,(964)),978,((987),1001,(1010)))))))";
        BinarySearchTree<Integer> yuvalsTree2=str2tree(yuvalsAns2);
        BinarySearchTree<BankAccount> yourTree2=(BinarySearchTree<BankAccount>)bank.exportAccountNumbers();
        BinarySearchTree<Integer> yourIntegerTree2=getIntegerTree(yourTree2);
        if((!bank.exportAccountNumbers().toString().equals(yuvalsAns2))&isTreesEquals(yuvalsTree2.root,yourIntegerTree2.root))
            System.out.println("####ERROR: 133#### contact me now!/n0504840490");
        if(isTreesEquals2Level(yuvalsTree2,yourIntegerTree2)){
            System.out.print("PASS");
            toAdd = " - not excectly as mine.(supposed to pass their automatic tests)";
            if(isTreesEquals(yuvalsTree2.root,yourIntegerTree2.root))
                toAdd = " - excectly as mine";
            System.out.println(toAdd);
        }
        else{
            System.out.println("fail");
        }
        String strFalseTrue="";
        String balanceAfter="";
        String balancebefore="";
        for (int i = 0; i < 100; i++){
            int accnum=(((i+1)*940817)%1019);
            int amount=(((i+1)*1299827)%3889);
            int whatToDo=(((int)(i%3)/2)*2)-1;
            balancebefore+=bank.lookUp(accnum).getBalance()+",";
            strFalseTrue+=(bank.spendOrDepositMoney(whatToDo*amount,accnum)?"t":"f")+",";
            balanceAfter+=bank.lookUp(accnum).getBalance()+",";
        }
        System.out.print("test 4 - ");
        String yuvalsAns3="2325,1343,361,2686,1704,722,3047,2065,1083,101,2426,1444,462,2787,1805,823,3148,2166,1184,202,2527,1545,563,2888,1906,924,3249,2267,1285,303,2628,1646,664,2989,2007,1025,43,2368,1386,404,2729,1747,765,3090,2108,1126,144,2469,1487,505,2830,1848,866,3191,2209,1227,245,2570,1588,606,2931,1949,967,3292,2310,1328,346,2671,1689,707,3032,2050,1068,86,2411,1429,447,2772,1790,808,3133,2151,1169,187,2512,1530,548,2873,1891,909,3234,2252,1270,288,2613,1631,649,2974,1992,1010,";
        if(balancebefore.equals(yuvalsAns3))
            System.out.println("PASS");
        else
            System.out.println("fail");
        System.out.println("-----spendOrDepositMoney()-----");
        System.out.print("test 1 - ");
        String yuvalsAns4="t,f,t,f,t,t,t,f,t,f,t,t,t,t,t,f,f,t,f,f,t,t,f,t,f,t,t,t,f,t,t,t,t,f,t,t,f,f,t,f,t,t,f,t,t,f,f,t,t,f,t,t,f,t,f,f,t,t,f,t,t,t,t,t,t,t,f,f,t,f,t,t,f,f,t,f,f,t,t,f,t,f,t,t,f,f,t,t,f,t,t,t,t,f,t,t,f,t,t,t,";
        if(strFalseTrue.equals(yuvalsAns4))
            System.out.println("PASS");
        else
            System.out.println("fail");
        System.out.print("test 2 - ");
        String yuvalsAns5="1424,1343,3064,2686,1088,2239,629,2065,1414,101,293,4478,416,1840,3653,823,3148,2828,1184,202,5892,1168,563,5067,1906,832,4242,373,1285,3999,1920,37,3174,2989,1584,2349,43,2368,1524,404,789,4588,765,2336,3763,1126,144,2938,117,505,6002,1664,866,5177,2209,1227,1045,869,1588,4109,2416,533,3284,74,2080,2459,346,2671,5523,707,1285,4698,1068,86,3873,1429,447,3048,613,808,6112,2151,277,1980,2512,1530,1155,1365,1891,4219,2912,1029,3394,288,2576,2569,649,234,5633,357,";
        if(balanceAfter.equals(yuvalsAns5))
            System.out.println("PASS");
        else
            System.out.println("fail");

        System.out.println("-----delete()-----");

        for (int i = 0; i < 100; i+=17){
            String str = (numToStr(i));
            bank.delete(str);
        }
        for (int i = 0; i < 100; i+=13){
            int accnum=(((i+1)*940817)%1019);
            bank.delete(accnum);
        }
        bank.balance();
        System.out.print("test 1 - ");
        if(((BankAccountBinarySearchTree)bank.exportAccountNumbers()).size()==87)
            System.out.println("PASS");
        else
            System.out.println("fail");
        System.out.print("test 2 - ");
        String yuvalsAns6="tree:((((((560),707,(854,(1001))),840,((987,(115)),262,(101,(248)))),395,(((542),381,(528,(675))),822,((661,(808)),955,(83,(941))))),69,((((216),363,(202,(349))),496,((482,(776)),923,(762,(909)))),37,(((184),23,(170,(317))),464,((303,(450)),597,(744,(583)))))),730,(((((877),5,(124,(271))),418,((565,(404)),551,(698,(845)))),684,(((831),106,(92,(239))),386,((225,(372)),519,(666,(505))))),652,((((799),946,(785,(932))),60,((207,(46)),193,(340,(487)))),326,(((473),620,(606,(753))),900,((886,(14)),161,(147,(441)))))))";
        BinarySearchTree<Integer> yuvalsTree3=str2tree(yuvalsAns6);
        BinarySearchTree<BankAccount> yourTree3=(BinarySearchTree<BankAccount>)bank.exportNames();
        BinarySearchTree<Integer> yourIntegerTree3=getIntegerTree(yourTree3);
        if((!yourTree3.toString().equals(yuvalsAns6))&isTreesEquals(yuvalsTree3.root,yourIntegerTree3.root))
            System.out.println("####ERROR: 166#### contact me now!/n0504840490");
        if((!isTreesEquals2Level(yuvalsTree3,yourIntegerTree3))&isTreesEquals(yuvalsTree3.root,yourIntegerTree3.root))
            System.out.println("####ERROR: 1661#### contact me now!/n0504840490");

        if(isTreesEquals2Level(yuvalsTree3,yourIntegerTree3)){
            System.out.print("PASS");
            toAdd = " - not excectly as mine.(supposed to pass their automatic tests)";
            if(isTreesEquals(yuvalsTree3.root,yourIntegerTree3.root))
                toAdd = " - excectly as mine";
            System.out.println(toAdd);
        }
        else{
            System.out.println("fail");
        }
        System.out.print("test 3 - ");
        String yuvalsAns7="tree:((((((5),14,(23,(37))),46,((60,(69)),83,(92,(101)))),106,(((115),124,(147,(161))),170,((184,(193)),202,(207,(216))))),225,((((239),248,(262,(271))),303,((317,(326)),340,(349,(363)))),372,(((381),386,(395,(404))),418,((441,(450)),464,(473,(482)))))),487,(((((496),505,(519,(528))),542,((551,(560)),565,(583,(597)))),606,(((620),652,(661,(666))),675,((684,(698)),707,(730,(744))))),753,((((762),776,(785,(799))),808,((822,(831)),840,(845,(854)))),877,(((886),900,(909,(923))),932,((941,(946)),955,(987,(1001)))))))";
        BinarySearchTree<Integer> yuvalsTree4=str2tree(yuvalsAns7);
        BinarySearchTree<BankAccount> yourTree4=(BinarySearchTree<BankAccount>)bank.exportAccountNumbers();
        BinarySearchTree<Integer> yourIntegerTree4=getIntegerTree(yourTree4);
        if((!yourTree4.toString().equals(yuvalsAns7))&isTreesEquals(yuvalsTree4.root,yourIntegerTree4.root))
            System.out.println("####ERROR: 177#### contact me now!\n0504840490");
        if((!isTreesEquals2Level(yuvalsTree4,yourIntegerTree4))&isTreesEquals(yuvalsTree4.root,yourIntegerTree4.root))
            System.out.println("####ERROR: 1771#### contact me now!\n0504840490");

        if(isTreesEquals2Level(yuvalsTree4,yourIntegerTree4)){
            System.out.print("PASS");
            toAdd = " - not excectly as mine.(supposed to pass their automatic tests)";
            if(isTreesEquals(yuvalsTree4.root,yourIntegerTree4.root))
                toAdd = " - excectly as mine";
            System.out.println(toAdd);
        }
        else{
            System.out.println("fail");
        }
    }
    public static BinarySearchTree<Integer> getIntegerTree(BinarySearchTree<BankAccount> tree){
        String str=tree.toString();
        BinarySearchTree<Integer> output=str2tree(str);
        return output;
    }
    public static String numToStr(int num){
        double len=(int)(Math.log(num)/Math.log(26));
        if(num==0)
            len=0;
        if(len==(int)len)
            len=(int)len+1;
        int rlen=(int)len;
        int[] arr=new int[rlen];
        for (int i = 0; i < rlen; i++){
            arr[i]=num%26;
            num/=26;
        }
        String str="";
        char[] chars=new char[rlen];
        for (int i = 0; i < rlen; i++){
            str+=(char)('a'+arr[i]);
        }
        return str;
    }
    public static int goodHeight(int numberOfNodes){

        return (int)Math.ceil(Math.log(numberOfNodes+1)/Math.log(2))-1;
    }
    public static int getHeight(BinaryNode bn){
        if(bn==null)
            return -1;
        int left=getHeight(bn.left);
        int right=getHeight(bn.right);
        return 1+Math.max(left,right);
    }
    public static boolean isBalancedbyHeight(BinaryNode bn){
        if(bn==null)
            return true;
        return bn.height()==goodHeight(bn.size());
    }

    public static boolean is2ChildrensNull(BinaryNode bn){
        boolean output=true;
        output&=bn.left==null;
        output&=bn.right==null;
        return output;
    }
    public static BinarySearchTree<Integer> str2tree(String str){
        str=str.replaceAll(",","");
        str=str.replaceAll("tree:","");
        BinarySearchTree<Integer> output=new BinarySearchTree<>(new IntegerComparator());
        if(str.equals(""))
            return output;
        int counter=0;
        int index=0;
        if(str.charAt(0)=='('){
            int i=0;
            for(;i<str.length()-1&&!(counter==1&str.charAt(i)!='(');i++){
                char c=str.charAt(i);
                if(c=='(')
                    counter++;
                else if(c==')'){
                    counter--;
                    if(counter==1)
                        break;
                }
            }
            index=i;
        }
        String left="";
        int nexOpenner = str.indexOf('(', index);
        if(str.charAt(index)==')'){
            index++;
            left = str.substring(1, index);
        }
        if(nexOpenner==-1)
            nexOpenner=str.length()-1;
        int data = Integer.parseInt(str.substring(index, nexOpenner));
        String right=str.substring(nexOpenner,str.length()-1);
        output.insert(data);
        output.root.left=str2tree(left).root;
        output.root.right=str2tree(right).root;
        return output;
    }
    public static <T> boolean isTreesEquals2Level(BinarySearchTree<T> t1,BinarySearchTree<T> t2){
        boolean output=true;
        if(t1.height()!=t2.height())
            return false;
        if(t1.size()!=t2.size())
            return false;

        for(T elem1:t1){
            boolean found=false;
            for(T elem2:t2)
                if(elem1.equals(elem2))
                    found=true;
            if(!found)
                return false;
        }
        for(T elem2:t2){
            boolean found=false;
            for(T elem1:t1)
                if(elem2.equals(elem1))
                    found=true;
            if(!found)
                return false;
        }
        return true;
    }
    public static <T> boolean isTreesEquals(BinaryNode<T> t1,BinaryNode<T> t2){
        if(t1==null&t2==null)
            return true;
        if(t1==null)
            return false;
        if(t2==null)
            return false;
        if(!t1.data.toString().equals(t2.data.toString()))
            return false;
        if((t1.right==null&t2.right!=null)|(t1.right!=null&t2.right==null))
            return false;
        if((t1.left==null&t2.left!=null)|(t1.left!=null&t2.left==null))
            return false;
        return isTreesEquals(t1.left,t2.left)&isTreesEquals(t1.right,t2.right);
    }
}
