# zhangxuechen5
## 实验目的
* 掌握读写/取入的方法
* 掌握string及其方法的应用
* 掌握异常处理结构

## 实验过程
* 1.创建java新项目
* 2.编写student和text两个类
* 3.编写student里的语句：姓名，年龄，性别，班级并输入赋值语句和返回语句
* 4.编写text语句，通过main方法的参数args赋值并添加throws语句告知可能抛出异常
* 5.创造3.中的四个对象并赋值
* 6.创建了 String 对象searchKey
* 7.用append进行数据的拼装并输出（？）
## 核心代码

```
public static String readFile() {
		System.out.println("开始读取文件.....");
		String fileStr="";
		FileInputStream fis = null;
		File file = new File("C:\\Users\\Admin\\Desktop\\1.txt");   		try {
			fis = new FileInputStream(file);
			int len = 0;
			byte[] buff = new byte[1024];                       			while((len = fis.read(buff)) != -1){
				fileStr=new String(buff, 0, len,"gbk");           			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();                                 			} 
			System.out.println("读取文件结束.....");                     		}

		return fileStr;
	}
	
	
	public static void writeFile(String newStr,String stuStr,String countStr)throws IOException
	{
		System.out.println("开始写入信息.....");
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Admin\\Desktop\\2.txt");         		fos.write(stuStr.getBytes());
		fos.write(newStr.getBytes());
		fos.write(countStr.getBytes());                                                                                   		fos.close();                                                                                                               		System.out.println("写入信息结束.....");
```

## 实验结果
![image](https://mail.qq.com/cgi-bin/viewfile?f=DF12188AC7C356DEFECA6D9C13FA9BBA68C180DE14603B8FBA6BDEC56209FCB864D968374C9E98D38A10410E756F0448B26BE366870C6613C4DAE19F54B5EF0319A4A8A2B6657FA8750672AAB7432B4BD78274A0A1C504F8298CF28FBED26163&mailid=ZL1230-3mhnh1rQ4INHP2o1PZg2Fab&sid=JpBRWYQNstEVMmc4&net=889192575)

![image](https://mail.qq.com/cgi-bin/viewfile?f=DF12188AC7C356DEFECA6D9C13FA9BBA68C180DE14603B8FDBE42880A77CE008A9CADBE9465A505B30001AB6CC70146BB66568C1CF65A3669A96DD33179C3C5989960C86EFAF14E99763E88F81A7760FFC04B4E863BFB1191EAD890395BCB885&mailid=ZL1230-0GYWQZwQBWaiEUQbO_ciUab&sid=JpBRWYQNstEVMmc4&net=889192575)


## 实验感想
老师您好，辛苦您浏览到这里，此次实验对我来说稍微有些困难，因想提交完整的实验结果，个别命令有所参考，通过大家的帮助和自己的努力，完整的完成了此次实验并对自己的学习进行查漏补缺（学习过程在text中用//注释了），可以说此次实验经历是五次实验中最充盈的，希望您可以酌情加减分（如果不行的话不要扣其他人的分，同学是好意帮我的谢谢老师呜呜呜），很开心能通过这次学习为java的实验课画上圆满的句号。谢谢老师！
