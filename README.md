# Втора лабораториска вежба по Софтверско инженерство
## Мила Славковска, бр. на индекс 216067
### Нумерирани линии од function
```
1  public static boolean function (User user, List<User> allUsers) {
2         if (user==null || user.getPassword()==null || user.getEmail()==null){
3             throw new RuntimeException("Mandatory information missing!");
          }

4         if (user.getUsername()==null){
5             user.setUsername(user.getEmail());
          }

6         int same = 1;
7         if (user.getEmail().contains("@") && user.getEmail().contains(".")) {
8             same = 0;
9             for (int i=0;i<allUsers.size();i++) {
10                User existingUser = allUsers.get(i);
11                if (existingUser.getEmail() == user.getEmail()) {
12                    same += 1;
                  }
13                if (existingUser.getUsername() == user.getUsername()) {
14                    same += 1;
                  }
              }
          }

15        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}";
16        String password = user.getPassword();
17        String passwordLower = password.toLowerCase();

18        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8) {
19            return false;
          }
          else {
20            if (!passwordLower.contains(" ")) {
21                for (int i = 0; i < specialCharacters.length(); i++) {
22                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) {
23                        return same == 0;
                      }
                  }
              }
          }
24        return false;
25    }
```

### Control Flow Graph
![CFG_216067](https://github.com/Mila-Slavkovska/SI_2023_lab2_216067/assets/109040935/8b66fcc1-ab91-403b-8a4c-ec24e1d0393c)

### Цикломатска комплексност
Цикломатската комплексност на овој код е 11, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли (јазлите со потемна сина боја). Во случајoв P=10, па цикломатската комплексност изнесува 11.

