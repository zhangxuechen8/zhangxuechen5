import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class Text {
	public static void main(String[] args ) throws IOException{
	    Student stu=new Student();                                                   //创建student对象
		System.out.print("请输入学生姓名:");
		Scanner scanner=new Scanner(System.in);	 //构造Scanner类的对象scan，接收从控制台输入的信息
		 if (scanner.hasNext()) {                                              //scanner.hasNext()要求输入一个值
			 String name=scanner.next();                    //String name = sc.next()中,会从sc中取出我们输入的那个值返回到name中
			 stu.setName(name);                                 //给name赋值 以下四段同理
		 }
		
		System.out.print("请输入学生年龄:");
		 if (scanner.hasNextInt()) {
		   int age=scanner.nextInt();
		   stu.setAge(age);
		 }
		
		
		System.out.print("请输入学生班级:"); 
		if (scanner.hasNext()) {
		String grade=scanner.next();
		stu.setGrade(grade);
		}
		
		System.out.print("请输入学生性别:");
		if (scanner.hasNext()) {
		   String sex=scanner.next();
		   stu.setSex(sex);
		}
		
		
		System.out.print("请输入需要统计的字或者词:");
		String searchKey="";                                            
		if (scanner.hasNext()) {
			searchKey=scanner.next();                          //关键字搜索
		}
		scanner.close();

		String str=readFile();
		int count=search(str,searchKey);
		String countStr="搜索的关键字:"+searchKey+",一共出现:"+count+"次";
		writeFile(convertStr(str),convertStudent(stu),countStr);
	}
	
	
	   public static int search(String str,String searchKey) {
			System.out.println("开始统计关键字.....");
	        int n = 0;                                                                           //计数器
	        int index = 0;                                                                    //指定字符的长度
	        index = str.indexOf(searchKey);                                        //indexOf返回关键字在字符串中首次出现的位置
	        while(index!=-1) {                                                            //关键字存在时n+1
	            n++;
	            index = str.indexOf(searchKey,index+1);   
	        }
	        System.out.println("关键字："+searchKey+",出现："+n+"次");
			System.out.println("关键字统计结束.....");
	        return n;
	    }
	
	
	/*
	 * 拼装学生信息
	 */
	public static  String convertStudent(Student stu){
		System.out.println("开始组装学生信息.....");
		StringBuffer stuStr=new StringBuffer();
		stuStr.append("姓名:").append(stu.getName()).append(" ");      //用append进行字符串的链接 使得刚刚赋值完成的name拼接在姓名：后面 ，以下同理
		stuStr.append("性别:").append(stu.getSex()).append("\n");
		stuStr.append("年龄:").append(stu.getAge()).append(" ");
		stuStr.append("班级:").append(stu.getGrade()).append("\n");
		stuStr.append("\n");
		System.out.println("组装学生信息结束.....");
		return stuStr.toString();
	}
	
	/***
	 * 转换读取到的字符串
	 * @param str
	 * @return
	 */
	public static  String convertStr(String str){
		System.out.println("开始处理文件信息.....");
		StringBuffer newStr=new StringBuffer();
		for(int index=0;index<str.length();index++){
			newStr.append(str.charAt(index));                                //获取单个字符，拼接成新字符串
			if(index>0){
				if((index+1)%7==0&&(index+1)%2!=0){     //由于循环是从0开始的，所以计算7的时候数据要加1    
					newStr.append(",");
				}else if((index+1)%7==0&&(index+1)%2==0){
					newStr.append("。\n");               //在句号后添加换行
				}
			}
		}
		newStr.append("\n");
		System.out.println("处理文件信息结束.....");
		return newStr.toString();
	}
	
	/***
	 * 读文件
	 * @return
	 */
	
	public static String readFile() {
		System.out.println("开始读取文件.....");
		String fileStr="";
		FileInputStream fis = null;
		File file = new File("C:\\Users\\Admin\\Desktop\\1.txt");     //此处为无标点长恨歌
		try {
			fis = new FileInputStream(file);
			int len = 0;
			byte[] buff = new byte[1024];                       //定义了一个byte类型的数组，数组长度为1024
			while((len = fis.read(buff)) != -1){
				fileStr=new String(buff, 0, len,"gbk");           //gbk编码格式
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();                                 //printStackTrace()：在命令行打印异常信息在程序中出错的位置及原因
			} 
			System.out.println("读取文件结束.....");                      //此段为异常处理 当try语句出现异常时，执行catch语句
		}

		return fileStr;
	}
	
	
	public static void writeFile(String newStr,String stuStr,String countStr)throws IOException
	{
		System.out.println("开始写入信息.....");
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Admin\\Desktop\\2.txt");         //这里的地址是已经改好的长恨歌
		fos.write(stuStr.getBytes());
		fos.write(newStr.getBytes());
		fos.write(countStr.getBytes());                                                                                   //字节流不支持直接写入字符串，所以将字符串变为字符数组
		fos.close();                                                                                                               //关闭资源
		System.out.println("写入信息结束.....");
	}

}

