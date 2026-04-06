import { createBrowserRouter } from 'react-router-dom';
import { LoginPage } from '@features/auth/pages/LoginPage';

/**
 * Global application router configuration using React Router
 */
export const router = createBrowserRouter([
  {
    path: '/',
    element: <LoginPage />, // Temporary root page
  },
  {
    path: '/auth/login',
    element: <LoginPage />,
  },
]);
