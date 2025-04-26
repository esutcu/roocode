<script lang="ts">
    import { goto } from '$app/navigation';
    import { browser } from '$app/environment';
    
    let firstName = '';
    let lastName = '';
    let email = '';
    let password = '';
    let confirmPassword = '';
    let role = 'INDIVIDUAL_STUDENT'; // Default role
    let creditPackage = ''; // Selected credit package
    let errorMessage = '';
    let isLoading = false;
    let packages = []; // Available credit packages
    
    // Fetch available credit packages
    async function fetchCreditPackages() {
      try {
        const response = await fetch('/api/credits/packages');
        if (response.ok) {
          packages = await response.json();
        }
      } catch (error) {
        console.error('Error fetching credit packages:', error);
      }
    }
    
    // Call on component mount
    if (browser) {
      fetchCreditPackages();
    }
    
    async function handleSignup() {
      // Validation
      if (!firstName || !lastName || !email || !password) {
        errorMessage = 'Please fill out all required fields';
        return;
      }
      
      if (password !== confirmPassword) {
        errorMessage = 'Passwords do not match';
        return;
      }
      
      if (password.length < 8) {
        errorMessage = 'Password must be at least 8 characters long';
        return;
      }
      
      if (!creditPackage) {
        errorMessage = 'Please select a credit package';
        return;
      }
      
      isLoading = true;
      errorMessage = '';
      
      try {
        // Register the user
        const registerResponse = await fetch('/api/auth/register', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            firstName,
            lastName,
            email,
            password,
            role
          })
        });
        
        if (registerResponse.ok) {
          const userData = await registerResponse.json();
          
          // Purchase the selected credit package
          const purchaseResponse = await fetch('/api/credits/purchase', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify({
              userId: userData.user.id,
              packageId: creditPackage
            })
          });
          
          if (purchaseResponse.ok) {
            // Now login the user
            const loginResponse = await fetch('/api/auth/login', {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json'
              },
              body: JSON.stringify({
                email,
                password
              })
            });
            
            if (loginResponse.ok) {
              const loginData = await loginResponse.json();
              
              // Store token and user info in localStorage
              if (browser) {
                localStorage.setItem('authToken', loginData.token);
                localStorage.setItem('userRole', loginData.user.role);
                localStorage.setItem('userId', loginData.user.id);
              }
              
              // Redirect to student dashboard
              goto('/dashboard/student');
            } else {
              const errorData = await loginResponse.json();
              errorMessage = errorData.message || 'Login failed after registration.';
            }
          } else {
            const errorData = await purchaseResponse.json();
            errorMessage = errorData.message || 'Failed to purchase credit package.';
          }
        } else {
          const errorData = await registerResponse.json();
          errorMessage = errorData.message || 'Registration failed. Please try again.';
        }
      } catch (error) {
        console.error('Signup error:', error);
        errorMessage = 'An error occurred during registration. Please try again.';
      } finally {
        isLoading = false;
      }
    }
    
    function navigateToLogin() {
      goto('/login');
    }
    
    function navigateToHome() {
      goto('/');
    }
  </script>
  
  <div class="min-h-screen bg-gray-100 flex flex-col justify-center py-12 sm:px-6 lg:px-8">
    <div class="sm:mx-auto sm:w-full sm:max-w-md">
      <div class="flex justify-center">
        <button on:click={navigateToHome} class="flex items-center">
          <img class="h-10 w-10" src="https://picsum.photos/seed/talkup/32/32.jpg" alt="TalkUp Logo" />
          <span class="ml-2 text-2xl font-bold text-talkup-blue">TalkUp</span>
        </button>
      </div>
      <h2 class="mt-6 text-center text-3xl font-extrabold text-gray-900">
        Create your account
      </h2>
      <p class="mt-2 text-center text-sm text-gray-600">
        Or
        <button on:click={navigateToLogin} class="font-medium text-talkup-blue hover:text-talkup-orange">
          sign in to your existing account
        </button>
      </p>
    </div>
  
    <div class="mt-8 sm:mx-auto sm:w-full sm:max-w-md">
      <div class="bg-white py-8 px-4 shadow sm:rounded-lg sm:px-10">
        <form class="space-y-6" on:submit|preventDefault={handleSignup}>
          {#if errorMessage}
            <div class="bg-red-50 border-l-4 border-red-400 p-4">
              <div class="flex">
                <div class="flex-shrink-0">
                  <svg class="h-5 w-5 text-red-400" viewBox="0 0 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zM8.707 7.293a1 1 0 00-1.414 1.414L8.586 10l-1.293 1.293a1 1 0 101.414 1.414L10 11.414l1.293 1.293a1 1 0 001.414-1.414L11.414 10l1.293-1.293a1 1 0 00-1.414-1.414L10 8.586 8.707 7.293z" clip-rule="evenodd" />
                  </svg>
                </div>
                <div class="ml-3">
                  <p class="text-sm text-red-700">
                    {errorMessage}
                  </p>
                </div>
              </div>
            </div>
          {/if}
          
          <div class="grid grid-cols-1 gap-y-6 gap-x-4 sm:grid-cols-2">
            <div>
              <label for="first-name" class="block text-sm font-medium text-gray-700">
                First name
              </label>
              <div class="mt-1">
                <input id="first-name" name="first-name" type="text" autocomplete="given-name" required
                  bind:value={firstName}
                  class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-talkup-blue focus:border-talkup-blue sm:text-sm"
                />
              </div>
            </div>
  
            <div>
              <label for="last-name" class="block text-sm font-medium text-gray-700">
                Last name
              </label>
              <div class="mt-1">
                <input id="last-name" name="last-name" type="text" autocomplete="family-name" required
                  bind:value={lastName}
                  class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-talkup-blue focus:border-talkup-blue sm:text-sm"
                />
              </div>
            </div>
          </div>
  
          <div>
            <label for="email" class="block text-sm font-medium text-gray-700">
              Email address
            </label>
            <div class="mt-1">
              <input id="email" name="email" type="email" autocomplete="email" required
                bind:value={email}
                class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-talkup-blue focus:border-talkup-blue sm:text-sm"
              />
            </div>
          </div>
  
          <div>
            <label for="password" class="block text-sm font-medium text-gray-700">
              Password
            </label>
            <div class="mt-1">
              <input id="password" name="password" type="password" autocomplete="new-password" required
                bind:value={password}
                class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-talkup-blue focus:border-talkup-blue sm:text-sm"
              />
            </div>
          </div>
  
          <div>
            <label for="confirm-password" class="block text-sm font-medium text-gray-700">
              Confirm password
            </label>
            <div class="mt-1">
              <input id="confirm-password" name="confirm-password" type="password" required
                bind:value={confirmPassword}
                class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-talkup-blue focus:border-talkup-blue sm:text-sm"
              />
            </div>
          </div>
  
          <div>
            <label for="credit-package" class="block text-sm font-medium text-gray-700">
              Select Credit Package
            </label>
            <div class="mt-1">
              <select id="credit-package" name="credit-package" required
                bind:value={creditPackage}
                class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-talkup-blue focus:border-talkup-blue sm:text-sm"
              >
                <option value="">Select a package</option>
                {#each packages as pkg}
                  <option value={pkg.id}>{pkg.name} - {pkg.credits} credits (${pkg.price})</option>
                {/each}
              </select>
            </div>
          </div>
  
          <div class="flex items-center">
            <input id="terms" name="terms" type="checkbox" required
              class="h-4 w-4 text-talkup-blue focus:ring-talkup-blue border-gray-300 rounded"
            />
            <label for="terms" class="ml-2 block text-sm text-gray-900">
              I agree to the 
              <a href="#" class="text-talkup-blue hover:text-talkup-orange">Terms of Service</a>
              and
              <a href="#" class="text-talkup-blue hover:text-talkup-orange">Privacy Policy</a>
            </label>
          </div>
  
          <div>
            <button type="submit" 
              class="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-talkup-blue hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-talkup-blue"
              disabled={isLoading}
            >
              {#if isLoading}
                <svg class="animate-spin -ml-1 mr-3 h-5 w-5 text-white" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24">
                  <circle class="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" stroke-width="4"></circle>
                  <path class="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"></path>
                </svg>
                Creating account...
              {:else}
                Create account
              {/if}
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>