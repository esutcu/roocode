<script>
  import { browser } from '$app/environment';
  import { goto } from '$app/navigation';
  
  // Logic for signing in or signing up
  function navigateToLogin() {
    goto('/login');
  }
  
  function navigateToSignup() {
    goto('/signup');
  }
  
  if (browser) {
    const mobileMenuButton = document.querySelector('[aria-label="Open main menu"]');
    const mobileMenu = document.getElementById('mobile-menu');
    
    if (mobileMenuButton && mobileMenu) {
      mobileMenuButton.addEventListener('click', () => {
        const expanded = mobileMenuButton.getAttribute('aria-expanded') === 'true';
        mobileMenuButton.setAttribute('aria-expanded', String(!expanded));
        mobileMenu.classList.toggle('hidden');
      });
    }
  }
</script>

<div class="min-h-screen bg-gray-50">
  <!-- Navigation Bar -->
  <nav class="bg-white shadow-md">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
      <div class="flex justify-between h-16">
        <div class="flex items-center">
          <div class="flex-shrink-0 flex items-center">
            <img class="h-8 w-8" src="https://picsum.photos/seed/talkup/32/32.jpg" alt="TalkUp Logo" />
            <span class="ml-2 text-xl font-bold text-talkup-blue">TalkUp</span>
          </div>
        </div>
        <!-- Mobile menu button -->
        <div class="flex items-center sm:hidden">
          <button type="button" class="inline-flex items-center justify-center p-2 rounded-md text-gray-400 hover:text-gray-500 hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-talkup-blue">
            <span class="sr-only">Open main menu</span>
            <svg class="h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" aria-hidden="true">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16" />
            </svg>
          </button>
        </div>
        <!-- Desktop navigation links -->
        <div class="hidden sm:flex sm:items-center">
          <div class="flex space-x-4">
            <a href="#features" class="px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Features</a>
            <a href="#pricing" class="px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Pricing</a>
            <a href="#testimonials" class="px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Testimonials</a>
            <button on:click={navigateToLogin} class="px-3 py-2 rounded-md text-sm font-medium text-talkup-blue hover:text-blue-800 hover:bg-gray-50">Sign In</button>
            <button on:click={navigateToSignup} class="px-3 py-2 rounded-md text-sm font-medium bg-talkup-blue text-white hover:bg-blue-700">Sign Up</button>
          </div>
        </div>
      </div>
    </div>
    
    <!-- Mobile navigation menu (hidden by default) -->
    <div class="sm:hidden hidden" id="mobile-menu">
      <div class="px-2 pt-2 pb-3 space-y-1">
        <a href="#features" class="block px-3 py-2 rounded-md text-base font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Features</a>
        <a href="#pricing" class="block px-3 py-2 rounded-md text-base font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Pricing</a>
        <a href="#testimonials" class="block px-3 py-2 rounded-md text-base font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Testimonials</a>
        <button on:click={navigateToLogin} class="block w-full text-left px-3 py-2 rounded-md text-base font-medium text-talkup-blue hover:text-blue-800 hover:bg-gray-50">Sign In</button>
        <button on:click={navigateToSignup} class="block w-full text-left px-3 py-2 rounded-md text-base font-medium bg-talkup-blue text-white hover:bg-blue-700">Sign Up</button>
      </div>
    </div>
  </nav>
  
  <!-- Hero Section -->
  <div class="relative bg-white overflow-hidden">
    <div class="max-w-7xl mx-auto">
      <div class="relative z-10 pb-8 bg-white sm:pb-16 md:pb-20 lg:max-w-2xl lg:w-full lg:pb-28 xl:pb-32">
        <main class="mt-10 mx-auto max-w-7xl px-4 sm:mt-12 sm:px-6 lg:mt-16 lg:px-8 xl:mt-20">
          <div class="sm:text-center lg:text-left">
            <h1 class="text-3xl tracking-tight font-extrabold text-gray-900 sm:text-4xl md:text-5xl">
              <span class="block">Improve your</span>
              <span class="block text-talkup-blue">language skills</span>
            </h1>
            <p class="mt-3 text-base text-gray-500 sm:mt-5 sm:text-lg sm:max-w-xl sm:mx-auto md:mt-5 md:text-xl lg:mx-0">
              Connect with native speakers and professional teachers for real conversations. Practice anytime, anywhere with TalkUp.
            </p>
            <div class="mt-5 sm:mt-8 sm:flex sm:justify-center lg:justify-start">
              <div class="rounded-md shadow">
                <button on:click={navigateToSignup} class="w-full flex items-center justify-center px-6 py-3 border border-transparent text-base font-medium rounded-md text-white bg-talkup-blue hover:bg-blue-700 md:py-3 md:text-lg md:px-8">
                  Get started
                </button>
              </div>
              <div class="mt-3 sm:mt-0 sm:ml-3">
                <a href="#how-it-works" class="w-full flex items-center justify-center px-6 py-3 border border-transparent text-base font-medium rounded-md text-talkup-blue bg-blue-100 hover:bg-blue-200 md:py-3 md:text-lg md:px-8">
                  Learn more
                </a>
              </div>
            </div>
          </div>
        </main>
      </div>
    </div>
    <div class="lg:absolute lg:inset-y-0 lg:right-0 lg:w-1/2">
      <img class="h-56 w-full object-cover sm:h-72 md:h-96 lg:w-full lg:h-full" src="https://picsum.photos/seed/language/1200/800" alt="Language Learning">
    </div>
  </div>
  
  <!-- How it Works Section -->
  <div id="how-it-works" class="py-10 bg-white sm:py-12">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
      <div class="lg:text-center">
        <h2 class="text-base text-talkup-blue font-semibold tracking-wide uppercase">How It Works</h2>
        <p class="mt-2 text-2xl leading-8 font-extrabold tracking-tight text-gray-900 sm:text-3xl">
          Learn languages through conversation
        </p>
        <p class="mt-4 max-w-2xl text-lg text-gray-500 lg:mx-auto">
          Our platform connects you with qualified teachers for personalized language practice.
        </p>
      </div>
      
      <div class="mt-10">
        <div class="space-y-8 sm:space-y-10 md:space-y-0 md:grid md:grid-cols-1 md:gap-y-8 lg:grid-cols-3 lg:gap-x-8">
          <!-- Step 1 -->
          <div class="relative">
            <div class="absolute flex items-center justify-center h-10 w-10 rounded-md bg-talkup-blue text-white">
              <svg class="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 10h18M7 15h1m4 0h1m-7 4h12a3 3 0 003-3V8a3 3 0 00-3-3H6a3 3 0 00-3 3v8a3 3 0 003 3z" />
              </svg>
            </div>
            <div class="ml-14">
              <h3 class="text-lg leading-6 font-medium text-gray-900">Purchase Credits</h3>
              <p class="mt-2 text-base text-gray-500">
                Buy credit packages to unlock conversation sessions with our teachers.
              </p>
            </div>
          </div>
          
          <!-- Step 2 -->
          <div class="relative">
            <div class="absolute flex items-center justify-center h-10 w-10 rounded-md bg-talkup-blue text-white">
              <svg class="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z" />
              </svg>
            </div>
            <div class="ml-14">
              <h3 class="text-lg leading-6 font-medium text-gray-900">Book Sessions</h3>
              <p class="mt-2 text-base text-gray-500">
                Schedule sessions with teachers based on your availability.
              </p>
            </div>
          </div>
          
          <!-- Step 3 -->
          <div class="relative">
            <div class="absolute flex items-center justify-center h-10 w-10 rounded-md bg-talkup-blue text-white">
              <svg class="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 10l4.553-2.276A1 1 0 0121 8.618v6.764a1 1 0 01-1.447.894L15 14M5 18h8a2 2 0 002-2V8a2 2 0 00-2-2H5a2 2 0 00-2 2v8a2 2 0 002 2z" />
              </svg>
            </div>
            <div class="ml-14">
              <h3 class="text-lg leading-6 font-medium text-gray-900">Practice & Improve</h3>
              <p class="mt-2 text-base text-gray-500">
                Join virtual sessions and improve your language skills through real conversations.
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <!-- Features Section -->
  <div id="features" class="py-10 bg-gray-50 sm:py-12">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
      <div class="lg:text-center">
        <h2 class="text-base text-talkup-blue font-semibold tracking-wide uppercase">Features</h2>
        <p class="mt-2 text-2xl leading-8 font-extrabold tracking-tight text-gray-900 sm:text-3xl">
          Everything you need to learn effectively
        </p>
      </div>
      
      <div class="mt-10">
        <div class="space-y-8 md:space-y-0 md:grid md:grid-cols-1 lg:grid-cols-2 md:gap-x-8 md:gap-y-8">
          <!-- Feature 1 -->
          <div class="relative">
            <div class="absolute flex items-center justify-center h-10 w-10 rounded-md bg-talkup-blue text-white">
              <svg class="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 4.354a4 4 0 110 5.292M15 21H3v-1a6 6 0 0112 0v1zm0 0h6v-1a6 6 0 00-9-5.197M13 7a4 4 0 11-8 0 4 4 0 018 0z" />
              </svg>
            </div>
            <div class="ml-14">
              <h3 class="text-lg leading-6 font-medium text-gray-900">Professional Teachers</h3>
              <p class="mt-2 text-base text-gray-500">
                Learn from qualified teachers who are native speakers or fluent in multiple languages.
              </p>
            </div>
          </div>
          
          <!-- Feature 2 -->
          <div class="relative">
            <div class="absolute flex items-center justify-center h-10 w-10 rounded-md bg-talkup-blue text-white">
              <svg class="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 8v4l3 3m6-3a9 9 0 11-18 0 9 9 0 0118 0z" />
              </svg>
            </div>
            <div class="ml-14">
              <h3 class="text-lg leading-6 font-medium text-gray-900">Flexible Scheduling</h3>
              <p class="mt-2 text-base text-gray-500">
                Book sessions at times that work for you, with our easy-to-use scheduling system.
              </p>
            </div>
          </div>
          
          <!-- Feature 3 -->
          <div class="relative">
            <div class="absolute flex items-center justify-center h-10 w-10 rounded-md bg-talkup-blue text-white">
              <svg class="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 10l4.553-2.276A1 1 0 0121 8.618v6.764a1 1 0 01-1.447.894L15 14M5 18h8a2 2 0 002-2V8a2 2 0 00-2-2H5a2 2 0 00-2 2v8a2 2 0 002 2z" />
              </svg>
            </div>
            <div class="ml-14">
              <h3 class="text-lg leading-6 font-medium text-gray-900">Virtual Classrooms</h3>
              <p class="mt-2 text-base text-gray-500">
                Join sessions from anywhere with our integrated video conferencing solution.
              </p>
            </div>
          </div>
          
          <!-- Feature 4 -->
          <div class="relative">
            <div class="absolute flex items-center justify-center h-10 w-10 rounded-md bg-talkup-blue text-white">
              <svg class="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 19v-6a2 2 0 00-2-2H5a2 2 0 00-2 2v6a2 2 0 002 2h2a2 2 0 002-2zm0 0V9a2 2 0 012-2h2a2 2 0 012 2v10m-6 0a2 2 0 002 2h2a2 2 0 002-2m0 0V5a2 2 0 012-2h2a2 2 0 012 2v14a2 2 0 01-2 2h-2a2 2 0 01-2-2z" />
              </svg>
            </div>
            <div class="ml-14">
              <h3 class="text-lg leading-6 font-medium text-gray-900">Progress Tracking</h3>
              <p class="mt-2 text-base text-gray-500">
                Monitor your language learning progress with detailed feedback after each session.
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <!-- Pricing Section -->
  <div id="pricing" class="py-10 bg-white sm:py-12">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
      <div class="lg:text-center">
        <h2 class="text-base text-talkup-blue font-semibold tracking-wide uppercase">Pricing</h2>
        <p class="mt-2 text-2xl leading-8 font-extrabold tracking-tight text-gray-900 sm:text-3xl">
          Credit Packages
        </p>
        <p class="mt-4 max-w-2xl text-lg text-gray-500 mx-auto">
          Choose the package that fits your learning needs and budget.
        </p>
      </div>
      
      <div class="mt-8 grid gap-6 sm:grid-cols-1 md:grid-cols-2 lg:grid-cols-3">
          <div class="flex-1">
            <h3 class="text-lg font-semibold text-gray-900">Basic Package</h3>
            <p class="mt-4 flex items-baseline text-gray-900">
              <span class="text-3xl font-extrabold tracking-tight">$49.99</span>
            </p>
            <p class="mt-4 text-sm text-gray-500">Perfect for beginners looking to try out the platform.</p>
            
            <!-- Feature list -->
            <ul role="list" class="mt-6 space-y-3">
              <li class="flex items-start">
                <svg class="h-5 w-5 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                </svg>
                <span class="ml-2 text-sm text-gray-500">10 Credits</span>
              </li>
              <li class="flex items-start">
                <svg class="h-5 w-5 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                </svg>
                <span class="ml-2 text-sm text-gray-500">1 credit = 1 session</span>
              </li>
              <li class="flex items-start">
                <svg class="h-5 w-5 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                </svg>
                <span class="ml-2 text-sm text-gray-500">30-day validity</span>
              </li>
            </ul>
          </div>
          
          <button on:click={navigateToSignup} class="mt-6 block w-full bg-talkup-blue py-2 px-4 border border-transparent rounded-md text-center font-medium text-white hover:bg-blue-700">
            Get Started
        
          </button>
        </div>
        </div>
              </div>
            </div>
        <!-- Standard Package -->
        <div class="relative p-5 bg-white border-2 border-talkup-blue rounded-lg shadow-sm flex flex-col">
          <div class="absolute -top-4 inset-x-0 flex justify-center">
            <div class="inline-block px-4 py-1 text-sm font-semibold text-white bg-talkup-orange rounded-full">
              Most Popular
            </div>
          </div>
          <div class="flex-1">
            <h3 class="text-lg font-semibold text-gray-900">Standard Package</h3>
            <p class="mt-4 flex items-baseline text-gray-900">
              <span class="text-3xl font-extrabold tracking-tight">$89.99</span>
            </p>
            <p class="mt-4 text-sm text-gray-500">Most popular choice for regular learners.</p>
            
            <!-- Feature list -->
            <ul role="list" class="mt-6 space-y-3">
              <li class="flex items-start">
                <svg class="h-5 w-5 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                </svg>
                <span class="ml-2 text-sm text-gray-500">20 Credits</span>
              </li>
              <li class="flex items-start">
                <svg class="h-5 w-5 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                </svg>
                <span class="ml-2 text-sm text-gray-500">1 credit = 1 session</span>
              </li>
              <li class="flex items-start">
                <svg class="h-5 w-5 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                </svg>
                <span class="ml-2 text-sm text-gray-500">60-day validity</span>
              </li>
              <li class="flex items-start">
                <svg class="h-5 w-5 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                </svg>
                <span class="ml-2 text-sm text-gray-500">Progress reports</span>
              </li>
            </ul>
          </div>
          
          <button on:click={navigateToSignup} class="mt-6 block w-full bg-talkup-orange py-2 px-4 border border-transparent rounded-md text-center font-medium text-white hover:bg-orange-600">
            Get Started
          </button>
        </div>
        
        <!-- Premium Package -->
        <!-- Premium Package (devam) -->
<div class="relative p-5 bg-white border border-gray-200 rounded-lg shadow-sm flex flex-col">
  <div class="flex-1">
    <h3 class="text-lg font-semibold text-gray-900">Premium Package</h3>
    <p class="mt-4 flex items-baseline text-gray-900">
      <span class="text-3xl font-extrabold tracking-tight">$199.99</span>
    </p>
    <p class="mt-4 text-sm text-gray-500">Best value for serious language learners.</p>
    
    <!-- Feature list -->
    <ul role="list" class="mt-6 space-y-3">
      <li class="flex items-start">
        <svg class="h-5 w-5 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
        </svg>
        <span class="ml-2 text-sm text-gray-500">50 Credits</span>
      </li>
      <li class="flex items-start">
        <svg class="h-5 w-5 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
        </svg>
        <span class="ml-2 text-sm text-gray-500">1 credit = 1 session</span>
      </li>
      <li class="flex items-start">
        <svg class="h-5 w-5 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
        </svg>
        <span class="ml-2 text-sm text-gray-500">90-day validity</span>
      </li>
      <li class="flex items-start">
        <svg class="h-5 w-5 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
        </svg>
        <span class="ml-2 text-sm text-gray-500">Priority booking</span>
      </li>
      <li class="flex items-start">
        <svg class="h-5 w-5 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
        </svg>
        <span class="ml-2 text-sm text-gray-500">Detailed progress reports</span>
      </li>
    </ul>
  </div>
  
  <button on:click={navigateToSignup} class="mt-6 block w-full bg-talkup-blue py-2 px-4 border border-transparent rounded-md text-center font-medium text-white hover:bg-blue-700">
    Get Started
  </button>
</div>