Thymeleaf는 Java 기반의 템플릿 엔진으로, 서버사이드에서 HTML을 렌더링하기 위해 사용됩니다. Spring Boot와 함께 사용될 때 특히 많이 활용됩니다. Thymeleaf의 문법은 HTML 태그와 속성을 활용하여 동적으로 데이터를 표시하거나 제어할 수 있도록 돕습니다. 아래는 Thymeleaf의 주요 문법과 기능에 대한 정리입니다.

### 1. 템플릿 기본 설정
Thymeleaf 템플릿 파일은 일반적으로 `.html` 확장자를 가지며, HTML5 표준을 따릅니다. 기본적으로 HTML 태그에 `xmlns:th="http://www.thymeleaf.org"`를 선언하여 Thymeleaf 구문을 사용할 수 있습니다.

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Thymeleaf Example</title>
</head>
<body>
    <!-- Thymeleaf 코드를 여기에 작성 -->
</body>
</html>
```

### 2. 텍스트 표시
Thymeleaf에서 서버 데이터를 HTML에 표시할 때는 `th:text`를 사용합니다.

```html
<p th:text="${message}">Placeholder Text</p>
```

- `${message}`: Spring Model 객체에서 `message`라는 이름으로 전달된 값을 표시합니다.

### 3. 변수 표현식
Thymeleaf에서는 `${}`을 사용하여 변수 값을 참조합니다.

```html
<p th:text="${user.name}">User Name</p>
```

- `${user.name}`: `user` 객체의 `name` 속성 값을 출력합니다.

### 4. 조건문
`th:if`와 `th:unless`를 사용하여 조건부 렌더링을 할 수 있습니다.

```html
<p th:if="${user.age > 18}">You are an adult.</p>
<p th:unless="${user.age > 18}">You are not an adult.</p>
```

### 5. 반복문
`th:each`를 사용하여 리스트나 배열을 반복할 수 있습니다.

```html
<ul>
    <li th:each="item : ${items}" th:text="${item}">Item</li>
</ul>
```

- `item : ${items}`: `items` 리스트의 각 요소를 `item`으로 참조하여 반복합니다.

### 6. 링크와 URL
`th:href`를 사용하여 동적으로 링크를 생성할 수 있습니다.

```html
<a th:href="@{/home}">Home</a>
<a th:href="@{/user/{id}(id=${user.id})}">User Profile</a>
```

- `@{/home}`: 기본 URL로 이동.
- `@{/user/{id}(id=${user.id})}`: `user.id` 값을 URL에 포함하여 링크 생성.

### 7. 인라인 텍스트
Thymeleaf는 인라인 표현식을 통해 속성 내에서 변수 값을 사용할 수 있습니다.

```html
<p>Hello, [[${user.name}]]!</p>
```

### 8. 폼 데이터 처리
Thymeleaf는 `th:action`과 `th:field`를 사용하여 폼 데이터를 처리할 수 있습니다.

```html
<form th:action="@{/submit}" method="post">
    <input type="text" th:field="*{name}" />
    <button type="submit">Submit</button>
</form>
```

- `th:action`: 폼 제출 시 요청할 URL을 지정.
- `th:field`: 입력 필드의 값을 Spring 모델에 바인딩.

### 9. 객체 접근과 안전한 평가
Thymeleaf는 안전한 객체 접근을 제공합니다. 객체가 `null`이어도 오류를 발생시키지 않고 빈 값을 출력합니다.

```html
<p th:text="${user?.address}">Address</p>
```

- `user?.address`: `user`가 `null`이면 안전하게 처리합니다.

### 10. Fragment 사용
Thymeleaf는 템플릿의 재사용을 위해 `th:fragment`와 `th:insert`를 지원합니다.

```html
<!-- fragment.html -->
<div th:fragment="header">
    <h1>Site Header</h1>
</div>

<!-- main.html -->
<div th:insert="fragments/header :: header"></div>
```

- `th:fragment`: 재사용 가능한 템플릿 부분을 정의.
- `th:insert`: 다른 HTML 파일의 fragment를 삽입.

Thymeleaf는 이러한 기본 문법을 통해 HTML을 동적으로 생성하고, 서버 데이터를 사용자에게 직관적으로 표현할 수 있도록 도와줍니다.