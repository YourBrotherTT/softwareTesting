package st;

public class Triangle {
	boolean isTriangle(int number) {
		int coin[] = {50,20,5,5,1,1,1};//按从大到小的顺序输入有的硬币
		boolean flag = false;  // flag记录能否分割，true可以，false不可以
		if(number >= 0 && number <=83) {//判断输入是否符合要求
			for(int i = 0 ; i < coin.length ; i ++) {
				if(number >= coin[i]) {//若number大于有的最大硬币,则拆分
					number -= coin[i];
				}
				if(number == 0 ){//所剩为0，即分解成功
					flag = true;
					break;
				}
			}
		}
		return flag;
	}
}
