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
      }
    },
    login: (token: string, userId: string, userRole: string) => {
      if (browser) {
        localStorage.setItem('authToken', token);
        localStorage.setItem('userId', userId);
        localStorage.setItem('userRole', userRole);
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
        localStorage.removeItem('authToken');
        localStorage.removeItem('userId');
        localStorage.removeItem('userRole');
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