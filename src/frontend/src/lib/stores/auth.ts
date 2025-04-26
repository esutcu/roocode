import { writable } from 'svelte/store';
import { browser } from '$app/environment';

type AuthState = {
  isAuthenticated: boolean;
  token: string | null;
  user: {
    id: string | null;
    role: string | null;
  };
  loading: boolean;
};

// Initial state
const initialState: AuthState = {
  isAuthenticated: false,
  token: null,
  user: {
    id: null,
    role: null
  },
  loading: true
};

// Create the store
const createAuthStore = () => {
  const { subscribe, set, update } = writable<AuthState>(initialState);

  return {
    subscribe,
    initialize: () => {
      if (browser) {
        try {
          const token = localStorage.getItem('authToken');
          const userId = localStorage.getItem('userId');
          const userRole = localStorage.getItem('userRole');

          if (token && userId && userRole) {
            update(state => ({
              ...state,
              isAuthenticated: true,
              token,
              user: {
                id: userId,
                role: userRole
              },
              loading: false
            }));
          } else {
            update(state => ({ ...state, loading: false }));
          }
        } catch (error) {
          console.error('Error initializing auth store:', error);
          update(state => ({ ...state, loading: false }));
        }
      } else {
        // For server-side rendering, just set loading to false
        update(state => ({ ...state, loading: false }));
      }
    },
    login: (token: string, userId: string, userRole: string) => {
      if (browser) {
        try {
          localStorage.setItem('authToken', token);
          localStorage.setItem('userId', userId);
          localStorage.setItem('userRole', userRole);
        } catch (error) {
          console.error('Error saving auth data:', error);
        }
      }

      update(state => ({
        ...state,
        isAuthenticated: true,
        token,
        user: {
          id: userId,
          role: userRole
        }
      }));
    },
    logout: () => {
      if (browser) {
        try {
          localStorage.removeItem('authToken');
          localStorage.removeItem('userId');
          localStorage.removeItem('userRole');
        } catch (error) {
          console.error('Error clearing auth data:', error);
        }
      }

      set({
        isAuthenticated: false,
        token: null,
        user: {
          id: null,
          role: null
        },
        loading: false
      });
    }
  };
};

export const auth = createAuthStore();