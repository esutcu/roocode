import { json } from '@sveltejs/kit';

export function GET() {
  // Mock credits data
  const credits = {
    credits: 100
  };

  return json(credits);
}