import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class Text {
	public static void main(String[] args ) throws IOException{
	    Student stu=new Student();                                                   //����student����
		System.out.print("������ѧ������:");
		Scanner scanner=new Scanner(System.in);	 //����Scanner��Ķ���scan�����մӿ���̨�������Ϣ
		 if (scanner.hasNext()) {                                              //scanner.hasNext()Ҫ������һ��ֵ
			 String name=scanner.next();                    //String name = sc.next()��,���sc��ȡ������������Ǹ�ֵ���ص�name��
			 stu.setName(name);                                 //��name��ֵ �����Ķ�ͬ��
		 }
		
		System.out.print("������ѧ������:");
		 if (scanner.hasNextInt()) {
		   int age=scanner.nextInt();
		   stu.setAge(age);
		 }
		
		
		System.out.print("������ѧ���༶:"); 
		if (scanner.hasNext()) {
		String grade=scanner.next();
		stu.setGrade(grade);
		}
		
		System.out.print("������ѧ���Ա�:");
		if (scanner.hasNext()) {
		   String sex=scanner.next();
		   stu.setSex(sex);
		}
		
		
		System.out.print("��������Ҫͳ�Ƶ��ֻ��ߴ�:");
		String searchKey="";                                            
		if (scanner.hasNext()) {
			searchKey=scanner.next();                          //�ؼ�������
		}
		scanner.close();

		String str=readFile();
		int count=search(str,searchKey);
		String countStr="�����Ĺؼ���:"+searchKey+",һ������:"+count+"��";
		writeFile(convertStr(str),convertStudent(stu),countStr);
	}
	
	
	   public static int search(String str,String searchKey) {
			System.out.println("��ʼͳ�ƹؼ���.....");
	        int n = 0;                                                                           //������
	        int index = 0;                                                                    //ָ���ַ��ĳ���
	        index = str.indexOf(searchKey);                                        //indexOf���عؼ������ַ������״γ��ֵ�λ��
	        while(index!=-1) {                                                            //�ؼ��ִ���ʱn+1
	            n++;
	            index = str.indexOf(searchKey,index+1);   
	        }
	        System.out.println("�ؼ��֣�"+searchKey+",���֣�"+n+"��");
			System.out.println("�ؼ���ͳ�ƽ���.....");
	        return n;
	    }
	
	
	/*
	 * ƴװѧ����Ϣ
	 */
	public static  String convertStudent(Student stu){
		System.out.println("��ʼ��װѧ����Ϣ.....");
		StringBuffer stuStr=new StringBuffer();
		stuStr.append("����:").append(stu.getName()).append(" ");      //��append�����ַ��������� ʹ�øոո�ֵ��ɵ�nameƴ�������������� ������ͬ��
		stuStr.append("�Ա�:").append(stu.getSex()).append("\n");
		stuStr.append("����:").append(stu.getAge()).append(" ");
		stuStr.append("�༶:").append(stu.getGrade()).append("\n");
		stuStr.append("\n");
		System.out.println("��װѧ����Ϣ����.....");
		return stuStr.toString();
	}
	
	/***
	 * ת����ȡ�����ַ���
	 * @param str
	 * @return
	 */
	public static  String convertStr(String str){
		System.out.println("��ʼ�����ļ���Ϣ.....");
		StringBuffer newStr=new StringBuffer();
		for(int index=0;index<str.length();index++){
			newStr.append(str.charAt(index));                                //��ȡ�����ַ���ƴ�ӳ����ַ���
			if(index>0){
				if((index+1)%7==0&&(index+1)%2!=0){     //����ѭ���Ǵ�0��ʼ�ģ����Լ���7��ʱ������Ҫ��1    
					newStr.append(",");
				}else if((index+1)%7==0&&(index+1)%2==0){
					newStr.append("��\n");               //�ھ�ź���ӻ���
				}
			}
		}
		newStr.append("\n");
		System.out.println("�����ļ���Ϣ����.....");
		return newStr.toString();
	}
	
	/***
	 * ���ļ�
	 * @return
	 */
	
	public static String readFile() {
		System.out.println("��ʼ��ȡ�ļ�.....");
		String fileStr="";
		FileInputStream fis = null;
		File file = new File("C:\\Users\\Admin\\Desktop\\1.txt");     //�˴�Ϊ�ޱ�㳤�޸�
		try {
			fis = new FileInputStream(file);
			int len = 0;
			byte[] buff = new byte[1024];                       //������һ��byte���͵����飬���鳤��Ϊ1024
			while((len = fis.read(buff)) != -1){
				fileStr=new String(buff, 0, len,"gbk");           //gbk�����ʽ
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();                                 //printStackTrace()���������д�ӡ�쳣��Ϣ�ڳ����г����λ�ü�ԭ��
			} 
			System.out.println("��ȡ�ļ�����.....");                      //�˶�Ϊ�쳣���� ��try�������쳣ʱ��ִ��catch���
		}

		return fileStr;
	}
	
	
	public static void writeFile(String newStr,String stuStr,String countStr)throws IOException
	{
		System.out.println("��ʼд����Ϣ.....");
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Admin\\Desktop\\2.txt");         //����ĵ�ַ���Ѿ��ĺõĳ��޸�
		fos.write(stuStr.getBytes());
		fos.write(newStr.getBytes());
		fos.write(countStr.getBytes());                                                                                   //�ֽ�����֧��ֱ��д���ַ��������Խ��ַ�����Ϊ�ַ�����
		fos.close();                                                                                                               //�ر���Դ
		System.out.println("д����Ϣ����.....");
	}

}

