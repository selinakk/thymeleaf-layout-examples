# Thymeleaf layout examples 🌱
>스프링부트에서 Thymeleaf 레이아웃을 간단히 구현한 예시 코드입니다<br/>
>A basic example of Thymeleaf layout implementation with Spring Boot
<br/>

[Thymeleaf](https://www.thymeleaf.org/) is a modern server-side Java template engine for both web and standalone environments.


## Dependency
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```
Thymeleaf Layout Dialect는 필요X<br/>
No need for Thymeleaf Layout Dialect

## Directory Structure
```
🗂️ src/main/resources
  📁 static
      └ css
          └ style.css
  📁 templates  
      └ common  
          ├ filename.html  
          ├ footer.html  
          ├ header.html  
          └ layout.html  
      └ pages  
          └ sub.html  
      └ index.html
```

## Examples
코드의 일부를 살펴보겠습니다 Here’s a glimpse of the code 👇

### layout.html
태그가 불필요하게 중첩되는 일을 막기 위해 th:block 태그를 사용했습니다 [참고: th:insert, th:replace, th:include의 차이](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#difference-between-thinsert-and-threplace-and-thinclude) <br/>
th:block tag is used to prevent unnecessary tag nesting [Difference between th:insert and th:replace (and th:include)](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#difference-between-thinsert-and-threplace-and-thinclude)
```
<body>
	<th:block th:insert="~{common/header :: header}"></th:block> <!--header-->
	<th:block th:replace="${content}"></th:block> <!--content-->
	<th:block th:insert="~{common/footer :: footer}"></th:block> <!--footer-->
</body>
```

### header.html
header 태그가 아니어도 th:fragment="header"인 요소를 쓸 수 있습니다<br/>
아래 코드 그대로인 경우 header 태그가, 주석을 푸는 경우 div class="header-wrapper"가 layout.html에 렌더링 됩니다<br/><br/>
It doesn't need to be a header tag as long as the element is defined with th:fragment="header"<br/>
When you uncomment the commented lines, a div class="header-wrapper" will be rendered instead of the header tag
```
<!--<div th:fragment="header" class="header-wrapper">	-->
	<header th:fragment>
		<h1>헤더입니다</h1>
		<ul>
			<li><a href="/">홈</a></li>
			<li><a href="/sub">서브</a></li>
		</ul>
	</header>
<!--</div>-->
```

### index.html
그다음은 가장 중요한 메인 컨텐츠 영역입니다<br/>
Lastly, the most important part -the content
```
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" th:replace="~{common/layout :: layout(~{::title}, ~{::content})}">
<head>
  <title>Thymeleaf layout 예제 - 인덱스</title>
</head>
<body>
	<th:block th:fragment="content">
		<div class="container">
			<h2>인덱스페이지 영역입니다</h2> 
			<th:block th:replace="~{common/filename :: fragment-name}"></th:block>
		</div>
	</th:block>
</body>
</html>
```

### Output
레이아웃이 잘 적용된 모습입니다
<img alt="index.html preview" src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FX1nXP%2FbtsKGMRjuyh%2FOKBUKkk3tSJqCeRRQ8t7E1%2Fimg.png"/>

## License
Copyright (c) 2024 selinakk
<br/><br/>

---
If you have any questions, encounter a bug, or anything else, feel free to reach out.
