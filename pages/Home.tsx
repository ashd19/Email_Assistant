import { Button, Container, Typography } from '@mui/material';

function Home() {
  const handleLogin = () => {
    window.location.href = 'http://localhost:8080/login/oauth2/code/github';
  };

  return (
    <Container>
      <Typography variant="h4">Welcome to Email Assistant</Typography>
      <Button variant="contained" onClick={handleLogin}>
        Login with GitHub
      </Button>
    </Container>
  );
}

export default Home;
