# ClassManagement Frontend Architecture

Dự án này sử dụng kiến trúc phân lớp dựa trên feature (Feature-Based Architecture) nhằm tối ưu hóa khả năng mở rộng và bảo trì.

## Cấu trúc thư mục `src/`

### 1. `app/`
Chứa các thiết lập ở cấp độ toàn ứng dụng (Global configuration).
- `router/`: Cấu hình React Router.
- `store/`: Quản lý state toàn cục (Redux, Zustand, v.v.).
- `providers/`: Các Context Provider toàn cục như Theme, AuthProvider, React Query.
- `index.tsx`: Entry point chính của ứng dụng React.

### 2. `features/`
**CORE:** Chứa logic nghiệp vụ được chia theo domain/feature. Mỗi feature là một folder độc lập:
- `api/`: Các lời gọi API riêng cho feature đó.
- `components/`: UI components chỉ dùng trong feature.
- `hooks/`: Custom hooks dành riêng cho feature.
- `pages/`: Các trang (Pages) thuộc feature này.
- `store/`: State riêng của feature (nếu có).
- `types/`: Định nghĩa kiểu dữ liệu TypeScript cho feature.

### 3. `shared/`
Chứa các thành phần dùng chung cho toàn bộ hệ thống.
- `components/`: Các UI components cơ bản (Button, Input, Modal, v.v.).
- `hooks/`: Các hooks tiện ích dùng chung (useDebounce, useFetch, v.v.).
- `utils/`: Các hàm helper, format dữ liệu.
- `constants/`: Các hằng số toàn cục.
- `types/`: Các kiểu dữ liệu dùng chung.

### 4. `services/`
Các tích hợp với bên thứ ba hoặc các dịch vụ dùng chung.
- `api-client.ts`: Cấu hình axios/fetch với base URL và interceptors.
- `websocket.ts`: Quản lý kết nối socket.
- `supabase.ts`: Tích hợp database/auth bên thứ ba.

### 5. `assets/`
Chứa các tệp tĩnh như hình ảnh, biểu tượng (icons), phông chữ (fonts).

### 6. `styles/`
Quản lý các tệp CSS toàn cục, biến môi trường CSS, hoặc cấu hình Tailwind.

---

## Path Aliases (Tên viết tắt đường dẫn)
Bạn có thể sử dụng các bí danh sau để tránh việc `../../../`:
- `@app/*` -> `src/app/*`
- `@features/*` -> `src/features/*`
- `@shared/*` -> `src/shared/*`
- `@services/*` -> `src/services/*`
- `@assets/*` -> `src/assets/*`
- `@styles/*` -> `src/styles/*`

Ví dụ: `import { Button } from '@shared/components/Button';`
