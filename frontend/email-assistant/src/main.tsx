import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './pages/index.css';
import App from './App.tsx'
// import AuthForm from './secure.tsx'\
// import Test from './test.tsx';
createRoot(document.getElementById('root')!).render(
  <StrictMode>
    
    <App />
  </StrictMode>,
)
