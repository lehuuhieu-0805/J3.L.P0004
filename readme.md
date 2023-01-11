## User Guide

#### Clone project

```
git clone https://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@github.com/lehuuhieu-0805/J3.L.P0004.git
```

#### Run project

1. Vào Sql Server chạy file script.sql để tạo database và table
2. Điền username và password của tài khoản Sql Server vào dòng 9 và 10

   ![context.xml](https://drive.google.com/uc?export=view&id=1gKZ0uMK-uuofHJxioXnDIYkII0RpTB9G)

3. Thêm thư viện sqljdbc vào project: click chuột phải vào folder libraries chọn 'Add JAR/Folder' chọn file 'sqljdbc42.jar'

   ![libraries](https://drive.google.com/uc?export=view&id=1YsvGt-fP_HVxli3zhDVkC5p8eOvviL4J)

4. Thêm thư viện jstl vào project: click chuột phải vào folder libraries chọn 'Add library' tìm 'JSTL 1.2.1' click 'Add Library'

   ![libraries](https://drive.google.com/uc?export=view&id=1YZppn12JkECiI8EFOgbjy2hJD4iUaGgS)

5. Để phục vụ cho tính năng gửi email khi đăng kí tài khoản thì chúng ta cần phải thêm 2 thư viện là ['activation jaf'](https://www.oracle.com/java/technologies/downloads.html) và ['javamail api'](https://www.oracle.com/java/technologies/javamail-api.html) sau đó thêm 2 thư viện vừa tải vào project: click chuột phải vào folder libraries chọn 'Add JAR/Folder' chọn file 'activation.jar' và 'mail.jar'

   ![libraries](https://drive.google.com/uc?export=view&id=1MZTkncaxnrbiz9hZuubudERZa0S5eVNc)
