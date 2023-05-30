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
![CFG_216067](https://github.com/Mila-Slavkovska/SI_2023_lab2_216067/assets/109040935/ddf4e67e-787d-47a7-9941-3938c1e23605)


### Цикломатска комплексност
Цикломатската комплексност на овој код е 11, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли (јазлите со потемна сина боја). Во случајoв P=10, па цикломатската комплексност изнесува 11.

### Тест случаи според критериумот Every Branch и објаснување				
![image](https://github.com/Mila-Slavkovska/SI_2023_lab2_216067/assets/109040935/a0a1ce51-54e0-4cdb-9e9c-192d9d2d883f)
<br/>За овој критериум потребни се 5 тест случаи. <br/>
Во првиот тест доволно е да биде задоволено user = null, па веднаш ќе се влезе во првиот if и ќе се фрли RuntimeException. <br/>
Во вториот тест, user.getUsername() е null и со ова username-от се поставува да е еднаков email-от на user. Исто така во овој тест email-от е валиден (содржи @ и .) и user постои како елемент во allUsers низата, покрај другуте корисници со што ќе се изминат сите гранки во овој if. Понатаму валидната лозинката содржи празно местно (" ") со што функцијата ќе заврши. <br/>
Во третиот тест случај email-от на user не е валиден и веднаш се продолжува со if-овите за лозинката која не содржи специјални карактери. Четвртиот тест случај е сличен на третиот, но во овој тест лозинката содржи специјални карактери. <br/>
На крај, во петтиот тест лозинката не е валидна (има помалку од 8 карактери), па функцијата завршува. <br/>
Со ова се изминуваат сите гранки.

### Тест случаи според критериумот Multiple Condition и објаснување
Според Multiple Condition критериумот за условот if (user==null || user.getPassword()==null || user.getEmail()==null) потребни се следните тест случаи: <br/>
<table>
          <tr>
                    <td><b>MCT</b></td> <td><b>Test case</b></td>
          </tr>
          <tr>
                    <td>T || X || X </td> <td>user=null, user.getPassword()=anything, user.getEmail()=anything </td>
          </tr>
          <tr>
                    <td>F || T || X </td> <td>user!=null, user.getPassword()=null, user.getEmail()=anything </td>
          </tr>
          <tr>
                    <td>F || F || T </td> <td>user!=null, user.getPassword()!=null, user.getEmail()=null </td>
          </tr>
          <tr>
                    <td>F || F || F </td> <td>user!=null, user.getPassword()!=null, user.getEmail()!=null </td>
          </tr>
</table>
