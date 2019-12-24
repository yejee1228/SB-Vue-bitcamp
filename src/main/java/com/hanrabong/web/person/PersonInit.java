package com.hanrabong.web.person;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
@Component
public class PersonInit implements ApplicationRunner {
	private PersonRepository personRepository;
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public PersonInit(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		long count = personRepository.count();
		if (count == 0) {
			Person person = null;
			String[][] mtx = {{ "kim", "1", "yejee", "1988-12-28","W","3","2","100" },
								{ "park", "1", "I", "1983-03-12","M","4","1","0" },
								{ "Lee", "1", "Today", "1983-05-05","W","3","3","90" },
								{ "Tak", "1", "what", "1984-01-10","W","2","6","80" },
								{ "Jang", "1", "do", "1924-11-01","M","1","5","90" },
								{ "Jeong", "1", "myhead", "1997-11-19","W","2","7","88" },
								{ "Song", "1", "sick", "1985-06-20","M","3","3","60" },
								{ "Cha", "1", "hing", "1983-11-10","M","4","1","20" },
								{ "Merry", "1", "merry", "1000-12-25","W","3","2","30" },
								{ "Crist", "1", "crist", "1983-12-25","W","1","7","66" },
								{ "Mas", "1", "mas", "1930-12-25","W","2","2","59" }};
			for (String[] arr : mtx) {

				person = new Person();
				person.setUserid(arr[0]);
				person.setPasswd(arr[1]);
				person.setName(arr[2]);
				person.setBirthday(df.parse(arr[3]));
				person.setGender(arr[4]);
				person.setHak(arr[5]);
				person.setBan(arr[6]);
				person.setScore(arr[7]);
				personRepository.save(person);

			}
			/*
			 * for(int i = 0; i<mtx.length; i++) { person = new Person();
			 * person.setUserid(mtx[i][0]); person.setPasswd(mtx[i][1]);
			 * person.setName(mtx[i][2]); person.setBirthday(df.parse(mtx[i][3]));
			 * personRepository.save(person); }
			 */
		}
	}

}
