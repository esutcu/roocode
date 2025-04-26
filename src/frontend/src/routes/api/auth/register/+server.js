import { json } from '@sveltejs/kit';

export async function POST({ request }) {
  try {
    const { firstName, lastName, email, password, role } = await request.json();
    
    // In a real application, you would create a user in your database
    // Here we will simply return a mock response
    
    const userData = {
      message: 'User registered successfully',
      user: {
        id: 'user-' + Math.floor(Math.random() * 1000),
        email,
        firstName,
        lastName,
        role,
        credits: 0
      }
    };
    
    return json(userData, { status: 201 });
  } catch (error) {
    console.error('Registration error:', error);
    return json({ message: 'Registration failed. Please try again.' }, { status: 400 });
  }
}