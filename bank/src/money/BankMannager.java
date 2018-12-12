package money;

import java.util.ArrayList;

public class BankMannager {
	public static void main(String[] args) throws Exception {

		BankDAO dao = new BankDAO();

		dao.insert(); // 1
		dao.update(); // 2
		BankDTO result = dao.dns(); // 3
		
		System.out.println(result.getId());
		System.out.println(result.getName());
		System.out.println(result.getAge());
		System.out.println(result.getTel());
		
	
		
		ArrayList<BankDTO> list = dao.selectAll(); // 4
		System.out.println("전체 회원리스트");
		System.out.println("전체 회원 : " + list.size());
		
		for (int i = 0; i < list.size(); i++) {
			BankDTO dto = list.get(i);
			System.out.println(dto.getId());
			System.out.println(dto.getName());
			System.out.println(dto.getAge());
			System.out.println(dto.getTel());

	}
	}
}
