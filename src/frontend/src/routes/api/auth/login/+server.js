import { json } from '@sveltejs/kit';

export async function POST({ request }) {
  try {
    const { email, password } = await request.json();
    
    // In a real application, you would validate credentials against your database
    // Here we will simply mock different user roles based on email for demonstration
    
    let userData;
    
    if (email.includes('admin')) {
      userData = {
        token: 'mock-jwt-token-admin',
        user: {
          id: 'admin-1',
          email: email,
          firstName: 'Admin',
          lastName: 'User',
          role: 'ADMIN',
          credits: 0
        }
      };
    } else if (email.includes('teacher')) {
      userData = {
        token: 'mock-jwt-token-teacher',
        user: {
          id: 'teacher-1',
          email: email,
          firstName: 'Teacher',
          lastName: 'User',
          role: 'TEACHER',
          credits: 0
        }
      };
    } else {
      userData = {
        token: 'mock-jwt-token-student',
        user: {
          id: 'student-1',
          email: email,
          firstName: 'Student',
          lastName: 'User',
          role: 'INDIVIDUAL_STUDENT',
          credits: 100
        }
      };
    }
    
    return json(userData, { status: 200 });
  } catch (error) {
    console.error('Login error:', error);
    return json({ message: 'Invalid login credentials' }, { status: 401 });
  }
}