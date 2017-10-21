package AmazonOA;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 买水果题 checkWinner(List<List<String>>codeList, List<String> shoppingcart) . 鍥磋鎴戜滑@1point 3 acres
 * 给你两个以排序好的list 比较codeList 是否为shopping cart的子集合 
 * 
 * 解题原则上就是用两个point对两个list去走如果能走完codeList 就回传1要不就是0
 * 
 * 
 **
 *
 *
 * 1.买水果
 * public static int checkWinner (List<List<String>> codeList, List<String> shoppingCart) {}
 * 说的是小明要帮公司买水果，给了一个codeList， 里面装的是他买的水果，给了一个shoppingCart里面装的是target水果，目标是检查codelist里的水果顺序是否和shoppingCart里的顺序匹配。.鏈枃鍘熷垱鑷�1point3acres璁哄潧
 * 注意的是只有codelist中的所有链表的item之后加起来小于等于shoppingcart里item之和才可能返回1。 另外在codelist中有可能出现item时 "anything"， 它可以和任意的水果匹配。
 * Ex1: 
 * codelist:. visit 1point3acres.com for more.
 * [
 * [apple, apple],
 * [orange, banana, orange]
 * ]
 * shoppingCart: [orange, apple, apple, orange, banana, orange]
 * return 1, 因为codelist里的顺序和shoppingcart里除了第一个orange之后的水果顺序匹配
 * 
 * Ex2: 
 * codelist:
 * [
 * [orange, banana, orange]，
 * [apple, apple]
 * ]
 * shoppingCart: [orange, apple, apple, orange, banana, orange]
 * return 0, 因为codeList里的顺序和shoppingcart没法匹配。 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 
 * 
 * Ex3: 
 * codelist:
 * [. Waral 鍗氬鏈夋洿澶氭枃绔�,
 * [apple, apple],
 * [orange, banana, orange],
 * [pear, orange, grape]
 * ]
 * shoppingCart: [orange, apple, apple, orange, banana, orange, pear, grape]
 * return 0, 因为codelist里最后一个[pear, orange, grape]中的orange没法和shoppingcart里的水果匹配。
 * 
 * Ex4:
 * codeList:
 * [
 * [apple, apple],
 * [orange, anything, orange]
 * ]. From 1point 3acres bbs
 * shoppingCart:
 * [orange, apple, apple, orange, mango, orange]. Waral 鍗氬鏈夋洿澶氭枃绔�,
 * return 1。
 * 
 * 
 * 
 * 
 * *
 * 
 * 第二个就是golf场地砍树，具体看http://www.1point3acres.com/bbs/thread-288738-1-1.html。 
 * 这题给点了起始点是最左上点，并且这个点肯定是1，可以走的。
 * 同时，树被砍掉了也会变成1，以后也可以走了。
 * 砍完一棵树后，从这个树点出发。
 * 具体思路是先找树，然后按高度sort树list，然后BFS一棵棵树。
 * 
 * *
 * 
 * 水果题其实就是strStr的升级版，就是给一个水果组合的list，让你在一个水果字符串的数组里找到这些水果组合，组合中间不能有别的水果捣乱，如果出现anything，可以且仅可以匹配一个水果。所以暴力解就是遍历每一个水果组合找到每一个组合的第一个水果后进入循环看看接下来的水果是否匹配，匹配则跳过该组合长度的水果，继续匹配下一个组合，若不匹配，则从下一个水果开始匹配。
 * 
 * 
 * *
 * 
 * 其实我第一次只过了51个……然后发现没有写清楚anything的case，加上anything之后就全过了，我也不晓得他有啥case……你在判断两个string的时候用的equals吗？还是“==”？
 * 
 * 
 * *
 * 
 * public static int checkWinner (List<List<String>> codeList, List<String> shoppingCart) {}
水果商举办比赛，codeList是水果商给出的购物单， shoppingCart是参赛者给出的序列，要求判断shoppingCart能否按顺序依次匹配codeList中的list。. from: 1point3acres.com/bbs 
list之间可以有间隔，list之内不能有。
codeList中会有anything，可以匹配任意值，但能且只能匹配一个。

注意的是各种空值的判断。
 * 
 * @author Shengyi
 *
 */


public class Fruit_CheckWinner {
	public static int checkWinner (List<List<String>> codeList, List<String> shoppingCart) {
		if (codeList == null || codeList.size() == 0 || shoppingCart == null || shoppingCart.size() == 0) {
			return 0;
		}
		
		List<String> code = new ArrayList<String>();
		
		for (int i = 0; i < codeList.size(); i++) {
			List<String> temp = new ArrayList<String>(codeList.get(i));
			for (int j = 0; j < temp.size(); j++) {
				code.add(temp.get(j));
			}
		}
		
		if (code.size() > shoppingCart.size()) {
			return -1;
		}
		
		for (int i = 0; i < shoppingCart.size() - code.size() + 1; i++) {
			int start = 0;
			int index = i;
			while(start < code.size()) {
				if (code.get(start).equals(shoppingCart.get(index))) {
					start++;
					index++;
				} else {
					break;
				}
			}
			
			if (start == code.size()) {
				return 1;
			} 
		}
		
		return 0;
	}
}











































