# wanted-pre-onboarding-backend
프리온보딩 백엔드 인턴십 선발과제


[링크] https://bow-hair-db3.notion.site/1850bca26fda4e0ca1410df270c03409

## 프로젝트 소개
채용공고 관리하기, 지원하기 서비스

## 개발 환경
- `Java 11`
- **IDE**: IntelliJ
- **Framework**: Spring Boot(2.x)
- **Database**: MySQL
- **ORM**: JPA

## ERD
<img width="400" alt="스크린샷 2023-10-12 오전 11 05 32" src="https://github.com/oh5chaeyoung/wanted-pre-onboarding-backend/assets/110815151/05976bef-49e5-49f0-bf45-9a22841056d3">
<img width="400" alt="스크린샷 2023-10-12 오전 11 00 45" src="https://github.com/oh5chaeyoung/wanted-pre-onboarding-backend/assets/110815151/616f381b-9a08-42e0-99d0-47c669d295f2">

- companies: 회사
- notices: 회사가 올리는 채용공고
- members: 지원자
- applications: 지원자의 지원 내역

## 프로젝트 구조
#### 1. application / company / member / notice

    |- controller
    
    |- domain
    
        |- entity
        
        |- repository
        
    |- dto
    
        |- request
        
        |- response
        
    |- service

#### 2. exception
- ApplicationAlreadyExistException
  
  사용자가 같은 채용공고에 1회만 지원하기 위해 사용한다. 지원 전에 이미 동일한 지원 내역이 있으면 예외 처리를 한다.
- CompanyNotFoundException
  
  findCompanyById(회사id로 회사 정보를 얻는 메소드)에서 사용한다.

## 주요 기능
### [회사] 채용공고 CRUD
#### 1. 채용공고를 등록합니다.


[POST] localhost:8080/notices

    {
    
        "회사_id": 회사_id,
        "position": "백엔드 주니어 개발자",
        "commission": 1000000,
        "content": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
        "skill": "Python"

    }
#### 2. 채용공고를 수정합니다.


[PUT] localhost:8080/notices/{noticeId}

    {
    
        "position": "백엔드 주니어 개발자",
        "commission": 1500000,    # 변경됨
        "content": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
        "skill": "Java"        # 변경됨

    }
#### 3. 채용공고를 삭제합니다.


[DELETE] localhost:8080/notices/{noticeId}


#### 4. 채용공고 목록을 가져옵니다.


[GET] localhost:8080/notices


#### 5. 채용 상세 페이지를 가져옵니다.

[GET] localhost:8080/notices/{noticeId}
- 채용 내용
- 회사가 올린 다른 채용공고


### [사용자] 채용공고 지원
#### 6. 사용자는 채용공고에 지원합니다

[POST] localhost:8080/applications
- 한 회사에 1번만 지원 가능
- 중복지원(회사id와 사용자id가 둘 다 일치하는 내용이 데이터베이스에 있는 경우)은 불가
