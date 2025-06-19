# Kotlin Spring Boot Todo API

このプロジェクトは、KotlinとSpring Bootを使用してTodoリストAPIを実装したサンプルです。このAPIは、Todoアイテムの作成、取得、更新、削除を行うためのエンドポイントを提供します。

## アーキテクチャ

このプロジェクトは **3層アーキテクチャ（レイヤードアーキテクチャ）** を採用しており、関心の分離によって保守性と拡張性を確保しています。

```text
kotlin-spring-api/
├── src/main/kotlin/com/example/api/
│   ├── ApiApplication.kt          【アプリケーション層】
│   ├── controller/
│   │   └── TodoController.kt      【プレゼンテーション層】
│   ├── service/
│   │   └── TodoService.kt         【ビジネス層】
│   ├── repository/
│   │   └── TodoRepository.kt      【データアクセス層】
│   └── model/
│       └── Todo.kt                【ドメイン層】
├── src/main/resources/
│   └── application.properties     【設定層】
├── build.gradle.kts               【ビルド設定】
└── README.md
```

### 各層の役割と実装すべき機能

#### 🏗️ **アプリケーション層（Application Layer）**

- **ファイル**: `ApiApplication.kt`
- **役割**: アプリケーションのエントリーポイントとして全体の起動・設定を管理
- **実装すべき機能**:
  - Spring Bootアプリケーションの起動設定
  - Bean設定とコンポーネントスキャンの定義
  - アプリケーション全体の初期化処理

#### 🌐 **プレゼンテーション層（Presentation Layer）**

- **ファイル**: `controller/TodoController.kt`
- **役割**: HTTPリクエストの受付とレスポンス返却を担当
- **実装すべき機能**:
  - RESTエンドポイントの定義（GET, POST, PUT, DELETE）
  - リクエストパラメータの検証とデータバインディング
  - HTTPステータスコードの適切な設定
  - エラーハンドリングとレスポンス形式の統一

#### 💼 **ビジネス層（Business Layer）**

- **ファイル**: `service/TodoService.kt`
- **役割**: アプリケーションのビジネスロジックを実装
- **実装すべき機能**:
  - ドメインルールとビジネス制約の実装
  - データの検証と変換処理
  - トランザクション制御
  - 複数のリポジトリを組み合わせた複雑な操作

#### 🗄️ **データアクセス層（Data Access Layer）**

- **ファイル**: `repository/TodoRepository.kt`
- **役割**: データベースとの接続とデータ永続化を管理
- **実装すべき機能**:
  - CRUD操作の抽象化
  - カスタムクエリの実装
  - データベース固有の操作の隠蔽
  - Spring Data JPAによる自動実装の活用

#### 📊 **ドメイン層（Domain Layer）**

- **ファイル**: `model/Todo.kt`
- **役割**: アプリケーションの核となるデータ構造とビジネスオブジェクトを定義
- **実装すべき機能**:
  - エンティティの属性定義
  - JPA アノテーションによるORM設定
  - データベーステーブルとのマッピング
  - ドメインオブジェクトの振る舞い（必要に応じて）

#### ⚙️ **設定層（Configuration Layer）**

- **ファイル**: `application.properties`
- **役割**: アプリケーション全体の設定管理
- **実装すべき機能**:
  - データベース接続設定
  - ログレベルとフォーマット設定
  - 環境別設定の切り替え
  - セキュリティ設定

### アーキテクチャの利点

- **関心の分離**: 各層が明確な責任を持ち、変更の影響を局所化
- **テスタビリティ**: 各層を独立してテスト可能
- **保守性**: コードの理解と修正が容易
- **拡張性**: 新機能の追加や既存機能の変更が簡単

## プロジェクト構成

- `src/main/kotlin/com/example/api/ApiApplication.kt`: アプリケーションのエントリーポイント。Spring Bootアプリケーションを起動するためのメイン関数が含まれています。
- `src/main/kotlin/com/example/api/controller/TodoController.kt`: Todoアイテムに関連するHTTPリクエストを処理するためのエンドポイントを定義する`TodoController`クラス。
- `src/main/kotlin/com/example/api/service/TodoService.kt`: Todoアイテムのビジネスロジックを実装する`TodoService`クラス。
- `src/main/kotlin/com/example/api/model/Todo.kt`: Todoアイテムのプロパティを定義する`Todo`データクラス。
- `src/main/kotlin/com/example/api/repository/TodoRepository.kt`: Todoアイテムのデータベース操作を定義する`TodoRepository`インターフェース。
- `src/main/resources/application.properties`: アプリケーションの設定を含むプロパティファイル。
- `build.gradle.kts`: プロジェクトの依存関係やビルド設定を含むGradleビルドスクリプト。

## セットアップ手順

1. このリポジトリをクローンします。

   ```bash
   git clone <repository-url>
   ```

2. プロジェクトディレクトリに移動します。

   ```bash
   cd kotlin-spring-api
   ```

3. 必要な依存関係をダウンロードします。

   ```bash
   ./gradlew build
   ```

4. アプリケーションを起動します。

   ```bash
   ./gradlew bootRun
   ```

5. APIエンドポイントにアクセスします。

   - `GET /todos`: すべてのTodoアイテムを取得
   - `GET /todos/{id}`: 指定したIDのTodoアイテムを取得
   - `POST /todos`: 新しいTodoアイテムを作成
   - `PUT /todos/{id}`: 指定したIDのTodoアイテムを更新
   - `DELETE /todos/{id}`: 指定したIDのTodoアイテムを削除

## 使用技術

- Kotlin
- Spring Boot
- Spring Data JPA
- H2 Database (または他のデータベース)

このプロジェクトは、KotlinとSpring Bootを使用したRESTful APIの基本的な実装を学ぶための良い出発点です。
