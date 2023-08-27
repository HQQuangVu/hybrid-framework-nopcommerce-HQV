package javaOOP;

public class Topic_07_Getter_Setter {

	// Kiểm tra/ Valid dữ liệu
	private String personName;
	private int personAge;
	private int personPhone;

	// Setter
	public void setPersonName(String personName) {
		if (personName == null || personName.isEmpty() || personName.isBlank()) {
			throw new IllegalArgumentException("Vui lòng nhập tên hợp lệ");
		} else {
			this.personName = personName;
		}
	}

	// Getter
	public String getPersonName() {
		return personName;
	}

	// Setter
	public void setPersonPhone(int personPhone) {
		if (!String.valueOf(personPhone).startsWith("0")) {
			throw new IllegalArgumentException("Số điện thoại phải bắt đầu bằng: 09 - 03.....");
		} else if (personPhone < 10 && personPhone > 11) {
			throw new IllegalArgumentException("Số điện thoại phải nhập 9 - 10 số");
		} else {
			this.personPhone = personPhone;
		}
	}

	// Getter
	public int getPersonPhone() {
		return personPhone;
	}

	// Getter
	public int getPersonAge() {
		return personAge;
	}
}
