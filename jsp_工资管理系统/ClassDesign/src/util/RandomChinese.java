package util;
// �ο�: https://blog.csdn.net/zzy2011266/article/details/42011047
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class RandomChinese {
	public static String  getName(){
			Random random=new Random(System.currentTimeMillis());
		
		/* 598 �ټ��� */
		
			String[] Surname= {"��","Ǯ","��","��","��","��","֣","��","��","��","��","��","��","��","��","��","��","��","��","��",
		
				  "��","��","ʩ","��","��","��","��","��","��","κ","��","��","��","л","��","��","��","ˮ","�","��","��","��","��","��","��","��","��","��",
		
				  "³","Τ","��","��","��","��","��","��","��","��","Ԭ","��","��","ʷ","��","��","��","�","Ѧ","��","��","��","��","��","��",
		
				  "��","��","��","��","��","��","��","��","ʱ","��","Ƥ","��","��","��","��","��","Ԫ","��","��","��","ƽ","��","��",
		
				  "��","��","��","Ҧ","��","տ","��","��","ë","��","��","��","��","��","��","��","��","��","̸","��","é","��","��","��","��",
		
				  "��","��","ף","��","��","��","��","��","��","ϯ","��","��","ǿ","��","·","¦","Σ","��","ͯ","��","��","÷","ʢ","��","��","��",
		
				  "��","��","��","��","��","��","��","��","��","��","��","֧","��","��","¬","Ī","��","��","��","��","��","��","Ӧ",
		
				  "��","��","��","��","��","��","��","��","��","��","��","ʯ","��","��","��","��","��","��","��","��","½","��","��","��",
		
				  "��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","ɽ",
		
				  "��","��","��","��","ȫ","ۭ","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��",
		
				  "ղ","��","��","Ҷ","��","˾","��","۬","��","��","��","ӡ","��","��","��","��","��","��","��","��","��","׿","��","��",
		
				  "��","��","��","��","��","��","��","��","˫","��","ݷ","��","��","̷","��","��","��","��","��","��","Ƚ","��","۪","Ӻ","ȴ",
		
				  "�","ɣ","��","ţ","��","ͨ","��","��","��","��","��","��","ũ","��","��","ׯ","��","��","��","��","Ľ","��","��","ϰ",
		
				  "��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","»",
		
				  "��","��","ŷ","��","��","Խ","¡","ʦ","��","��","��","��","��","��","��","��","��","��","��","��","��",
		
				  "��","ɳ","��","��","��","��","��","��","��","��","��","��","��","��","Ȩ","��","��","��","��","��",
		
				  "��","��","˧","��","��","��","��","��","��","��","��","��","��","��","��","Ĳ","��","٦","��","��","ī",
		
				  "��","��","��","��","١","��","��","��","��","��","��","��","��","��","��","չ","��","̴","��","��","��","��","˴","¥",
		
				  "��","ð","��","��","��","��","��","ԭ","��","��","��","��","��","��","��","��","��","��","��","��","��",
		
				  "ľ","��","��","��","ö","��","��","�","��","��","��","��","��","��","��","��","��","��","��","��","��","��",
		
				 "��ٹ","˾��","�Ϲ�","ŷ��","�ĺ�","���","����","����","����","�ʸ�","����","ξ��","����","�̨","��ұ","����",
		
				  "���","����","����","̫��","����","����","����","��ԯ","���","����","����","����","Ľ��","����","����","˾ͽ","˾��","أ��","˾��",
		
				  "����","����","�ӳ�","��ľ","����","����","���","����","����","����","�ذ�","�й�","�׸�","����","�θ�","����","����","΢��",
		
				  "����","����","����","����","�Ϲ�","����","����","����","̫ʷ","�ٳ�","����","��ͻ","����","����","����","��ĸ","˾��","����","Ӻ��",
		
				  "����","����","��®","����","�Ϲ�","����","����"};
		
		
		
				int index=random.nextInt(Surname.length-1);		
		
				String name = Surname[index]; //���һ�����������
		
		
		
				/* �ӳ�������ѡȡһ������������Ϊ�� */
				
				if(random.nextBoolean()){
				
					name+=RandomChinese.getChinese()+RandomChinese.getChinese();
				
				}else {
				
					name+=RandomChinese.getChinese();
				
				}
				
				System.out.println(name);
				return name;
	}
	public static String getChinese() {

		String str = null;

		int highPos, lowPos;

		Random random = new Random();

		highPos = (176 + Math.abs(random.nextInt(71)));//���룬0xA0��ͷ���ӵ�16����ʼ����0xB0=11*16=176,16~55һ�����֣�56~87��������

		random=new Random();

		lowPos = 161 + Math.abs(random.nextInt(94));//λ�룬0xA0��ͷ����Χ��1~94��

 

		byte[] bArr = new byte[2];

		bArr[0] = (new Integer(highPos)).byteValue();

		bArr[1] = (new Integer(lowPos)).byteValue();

		try {

			str = new String(bArr, "GB2312");	//��λ����ϳɺ���

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();

		}

			return str;

	}
}
