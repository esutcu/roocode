import { json } from '@sveltejs/kit';

export function GET() {
  // Mock user data
  const user = {
    id: '1',
    email: 'student@example.com',
    firstName: 'John',
    lastName: 'Doe',
    credits: 100
  };

  return json(user);
}