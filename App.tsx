import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './pages/Home.tsx';
import EmailGenerator from './pages/EmailGenerator';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} /> 
        <Route path="/email" element={<EmailGenerator />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
