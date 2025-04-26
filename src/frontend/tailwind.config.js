/** @type {import('tailwindcss').Config} */
export default {
  content: [
    './src/**/*.{html,js,svelte,ts}',
  ],
  theme: {
    extend: {
      colors: {
        'talkup-blue': '#3871B1',
        'talkup-orange': '#FF8913',
      }
    },
  },
  plugins: [],
}